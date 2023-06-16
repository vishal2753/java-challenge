package jp.co.axa.apidemo.services;

import jp.co.axa.apidemo.entities.Employee;
import jp.co.axa.apidemo.repositories.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Service Implementation for managing Employee entities.
 */
@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    /**
     * Retrieves all employees.
     *
     * @return A list of all employees.
     */
    @Cacheable(value = "employees")
    @Override
    public List<Employee> retrieveEmployees() {
        return employeeRepository.findAll();
    }

    /**
     * Retrieves an employee by ID.
     *
     * @param employeeId The ID of the employee.
     * @return The employee with the given ID.
     */
    @Override
    public Employee getEmployee(Long employeeId) {
        return employeeRepository.findById(employeeId).orElse(null);
    }

    /**
     * Saves a new employee.
     *
     * @param employee The employee to save.
     */
    @Override
    public Employee saveEmployee(Employee employee) {
        return employeeRepository.save(employee);
    }

    /**
     * Deletes an employee by ID.
     *
     * @param employeeId The ID of the employee to delete.
     */
    @Override
    public void deleteEmployee(Long employeeId) {
        employeeRepository.deleteById(employeeId);
    }

    /**
     * Updates an employee.
     *
     * @param employee The employee data to update.
     */
    @Override
    public Employee updateEmployee(Employee employee) {
        return employeeRepository.save(employee);
    }
}