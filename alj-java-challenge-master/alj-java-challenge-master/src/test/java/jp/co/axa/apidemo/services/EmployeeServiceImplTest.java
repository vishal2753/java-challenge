package jp.co.axa.apidemo.services;

import jp.co.axa.apidemo.entities.Employee;
import jp.co.axa.apidemo.repositories.EmployeeRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

/**
 * Test Class for EmployeeService.
 */
public class EmployeeServiceImplTest {

    @InjectMocks
    private EmployeeServiceImpl employeeService;

    @Mock
    private EmployeeRepository employeeRepository;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testRetrieveEmployees() {
        // Create a list of employees for testing
        List<Employee> employees = new ArrayList<>();
        employees.add(new Employee(1L, "John Doe", 5000, "Engineering"));
        employees.add(new Employee(2L, "Jane Smith", 6000, "Marketing"));

        // Set up the mock behavior
        when(employeeRepository.findAll()).thenReturn(employees);

        // Call the service method
        List<Employee> retrievedEmployees = employeeService.retrieveEmployees();

        // Verify the results
        assertEquals(2, retrievedEmployees.size());
        assertEquals("John Doe", retrievedEmployees.get(0).getName());
        assertEquals(Integer.valueOf(5000), retrievedEmployees.get(0).getSalary());
        assertEquals("Engineering", retrievedEmployees.get(0).getDepartment());
        assertEquals("Jane Smith", retrievedEmployees.get(1).getName());
        assertEquals(Integer.valueOf(6000), retrievedEmployees.get(1).getSalary());
        assertEquals("Marketing", retrievedEmployees.get(1).getDepartment());

        // Verify that the repository method was called
        verify(employeeRepository, times(1)).findAll();
    }

    @Test
    public void testGetEmployee() {
        // Create an employee for testing
        Employee employee = new Employee(1L, "John Doe", 5000, "Engineering");

        // Set up the mock behavior
        when(employeeRepository.findById(1L)).thenReturn(Optional.of(employee));

        // Call the service method
        Employee retrievedEmployee = employeeService.getEmployee(1L);

        // Verify the result
        assertEquals("John Doe", retrievedEmployee.getName());
        assertEquals(Integer.valueOf(5000), retrievedEmployee.getSalary());
        assertEquals("Engineering", retrievedEmployee.getDepartment());

        // Verify that the repository method was called
        verify(employeeRepository, times(1)).findById(1L);
    }

    @Test
    public void testSaveEmployee() {
        // Create an employee for testing
        Employee employee = new Employee(1L, "John Doe", 5000, "Engineering");

        // Set up the mock behavior
        when(employeeRepository.save(employee)).thenReturn(employee);

        // Call the service method
        Employee savedEmployee = employeeService.saveEmployee(employee);

        // Verify the result
        assertEquals("John Doe", savedEmployee.getName());
        assertEquals(Integer.valueOf(5000), savedEmployee.getSalary());
        assertEquals("Engineering", savedEmployee.getDepartment());

        // Verify that the repository method was called
        verify(employeeRepository, times(1)).save(employee);
    }

    @Test
    public void testDeleteEmployee() {
        // Call the service method
        employeeService.deleteEmployee(1L);

        // Verify that the repository method was called
        verify(employeeRepository, times(1)).deleteById(1L);
    }

    @Test
    public void testUpdateEmployee() {
        // Create an employee for testing
        Employee employee = new Employee(1L, "John Doe", 5000, "Engineering");

        // Set up the mock behavior
        when(employeeRepository.save(employee)).thenReturn(employee);

        // Call the service method
        Employee updatedEmployee = employeeService.updateEmployee(employee);

        // Verify the result
        assertEquals("John Doe", updatedEmployee.getName());
        assertEquals(Integer.valueOf(5000), updatedEmployee.getSalary());
        assertEquals("Engineering", updatedEmployee.getDepartment());

        // Verify that the repository method was called
        verify(employeeRepository, times(1)).save(employee);
    }
}
