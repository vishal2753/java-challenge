package jp.co.axa.apidemo.controllers;

import jp.co.axa.apidemo.entities.Employee;
import jp.co.axa.apidemo.services.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

/**
 * REST Controller for managing Employee entities.
 */
@RestController
@RequestMapping("/api/v1")
public class EmployeeController {

    private static final Logger logger = LoggerFactory.getLogger(EmployeeController.class);
    @Autowired
    private EmployeeService employeeService;

    /**
     * Retrieves all employees.
     *
     * @return A list of all employees.
     */
    @GetMapping("/employees")
    @ResponseBody
    public List<Employee> getEmployees() {
        logger.info("Fetching all employees");
        return employeeService.retrieveEmployees();
    }

    /**
     * Retrieves a single employee by ID.
     *
     * @param employeeId The ID of the employee.
     * @return The employee with the given ID.
     */
    @GetMapping("/employees/{employeeId}")
    @ResponseBody
    public Employee getEmployee(@PathVariable(name="employeeId") Long employeeId) {
        logger.info("Fetching employee with employeeID: {}", employeeId);
        return employeeService.getEmployee(employeeId);
    }

    /**
     * Creates a new employee.
     *
     * @param employee The employee to create.
     * @return The created employee.
     */
    @PostMapping("/employees")
    public ResponseEntity<Employee> saveEmployee(@RequestBody Employee employee) {
        Employee savedEmployee = employeeService.saveEmployee(employee);
        logger.info("Employee Saved Successfully: {}", savedEmployee);
        return ResponseEntity.ok(savedEmployee);
    }


    /**
     * Deletes an employee by ID.
     *
     * @param employeeId The ID of the employee to delete.
     */
    @DeleteMapping("/employees/{employeeId}")
    public void deleteEmployee(@PathVariable(name="employeeId") Long employeeId){
        employeeService.deleteEmployee(employeeId);
        logger.info("Employee Deleted Successfully");
        System.out.println("Employee Deleted Successfully");
    }

    /**
     * Updates an employee.
     *
     * @param "employee" The employee data to update.
     * @param "employeeId" The ID of the employee to update.
     */
    @PutMapping("/employees/{employeeId}")
    public ResponseEntity<Employee> updateEmployee(@RequestBody Employee updatedEmployee, @PathVariable(name="employeeId") Long employeeId) {
        Employee existingEmployee = employeeService.getEmployee(employeeId);

        if(existingEmployee == null) {
            return ResponseEntity.notFound().build();
        }

        existingEmployee.setName(updatedEmployee.getName());
        existingEmployee.setSalary(updatedEmployee.getSalary());
        existingEmployee.setDepartment(updatedEmployee.getDepartment());

        employeeService.updateEmployee(existingEmployee);

        logger.info("Employee Updated Successfully: {}", existingEmployee);

        return ResponseEntity.ok(existingEmployee);
    }
}