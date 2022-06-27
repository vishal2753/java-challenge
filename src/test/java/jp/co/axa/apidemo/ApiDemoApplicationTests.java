package jp.co.axa.apidemo;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import java.util.Optional;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.Order;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import jp.co.axa.apidemo.entities.Employee;
import jp.co.axa.apidemo.error.EmployeeNotFoundException;
import jp.co.axa.apidemo.repositories.EmployeeRepository;
import jp.co.axa.apidemo.services.EmployeeService;

@RunWith(SpringRunner.class)
@SpringBootTest
@ActiveProfiles("test")
//@DataJpaTest
//@AutoConfigureTestDatabase(replace=Replace.NONE)
public class ApiDemoApplicationTests {

	@Autowired
	EmployeeService service;

	@Autowired
	private EmployeeRepository employeeRepository;

	@Before
	public void contextLoads() {

	}

	@Test
	@Order(1)
	public void checkSaveEmployee() {
		Employee emp0 = new Employee();
		emp0.setName("Emp0");
		emp0.setDepartment("IT0");
		emp0.setSalary(100000);
		service.saveEmployee(emp0);
		Assert.assertNotNull(emp0.getId());
		Assert.assertEquals(emp0.getName(), "Emp0");
	}

	@Test
	@Order(2)
	public void checkSaveEmployeeRepo() {
		Employee emp1 = new Employee();
		emp1.setName("Emp001");
		emp1.setDepartment("IT001");
		emp1.setSalary(10000011);
		Employee empcheck = employeeRepository.save(emp1);
		Assert.assertNotNull(empcheck);
		Assert.assertEquals(emp1.getName(), empcheck.getName());
	}

	@Test
	@Order(3)
	public void getEmployee() {
		Employee emp3 = new Employee();
		emp3.setName("Emp3");
		emp3.setDepartment("IT3");
		emp3.setSalary(1000003);
		Employee empcheck = employeeRepository.save(emp3);

		Optional<Employee> optEmp = employeeRepository.findById(empcheck.getId());
		Long id = optEmp.get().getId();
		Long id2 = 2L;
		Assert.assertEquals(id, id2);

	}

	@Test
	@Order(4)
	public void findAllEmployees() {
		List<Employee> employees = employeeRepository.findAll();
		Assert.assertNotNull(employees);
		assertThat(employees).hasSizeGreaterThan(0);
	}

	@Test
	@Order(5)
	public void checkUpdate() {
		Employee emp4 = new Employee();
		emp4.setName("Emp14");
		emp4.setDepartment("IT14");
		emp4.setSalary(10000014);
		employeeRepository.save(emp4);

		Employee emp5 = new Employee();
		emp5.setName("Emp25");
		emp5.setDepartment("IT25");
		emp5.setSalary(50000025);
		employeeRepository.save(emp5);

		Long id = emp4.getId();
		System.out.println(id);
		Employee emp6 = service.getEmployee(id);

		emp6.setId(emp5.getId());
		emp6.setName(emp5.getName());
		emp6.setDepartment(emp5.getDepartment());
		emp6.setSalary(emp5.getSalary());
		employeeRepository.save(emp6);

		Employee checkEmp = service.getEmployee(emp6.getId());

		Assert.assertEquals(checkEmp.getId(), emp5.getId());
		Assert.assertEquals(checkEmp.getName(), emp5.getName());
		Assert.assertEquals(checkEmp.getDepartment(), emp5.getDepartment());
		Assert.assertEquals(checkEmp.getSalary(), emp5.getSalary());
	}

	@Test(expected = EmployeeNotFoundException.class)
	@Order(6)
	public void deleteEmployee() {
		List<Employee> employees = employeeRepository.findAll();
		System.out.println("******BEFORE DELETE************");
		System.out.println(employees);
		System.out.println("******BEFORE DELETE************");
		long id = 2L;
		Employee emp7 = service.getEmployee(id);

		service.deleteEmployee(emp7.getId());
		List<Employee> employees1 = employeeRepository.findAll();
		System.out.println("********AFTER DELETE*********");
		System.out.println(employees1);
		System.out.println("********AFTER DELETE**********");

		Employee emp8 = service.getEmployee(id);
		id = emp8.getId();

	}

}