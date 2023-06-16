package jp.co.axa.apidemo.services;

import jp.co.axa.apidemo.entities.Employee;

import java.util.List;

/**
 * Service interface for managing Employee entities.
 */
public interface EmployeeService {

    /**
     * Retrieves all employees.
     *
     * @return A list of all employees.
     */
    List<Employee> retrieveEmployees();

    /**
     * Retrieves an employee by ID.
     *
     * @param employeeId The ID of the employee.
     * @return The employee with the given ID.
     */
    Employee getEmployee(Long employeeId);

    /**
     * Saves a new employee.
     *
     * @param employee The employee to save.
     */
    Employee saveEmployee(Employee employee);

    /**
     * Deletes an employee by ID.
     *
     * @param employeeId The ID of the employee to delete.
     */
    void deleteEmployee(Long employeeId);

    /**
     * Updates an employee.
     *
     * @param employee The employee data to update.
     */
    Employee updateEmployee(Employee employee);
}