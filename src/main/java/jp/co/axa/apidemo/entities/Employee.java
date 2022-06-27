package jp.co.axa.apidemo.entities;

import java.util.Objects;

//import lombok.Getter;
//import lombok.Setter;
//import lombok.experimental.Accessors;
//import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.sun.istack.NotNull;

import io.swagger.annotations.ApiModelProperty;

@Entity 
@Table(name = "EMPLOYEE")

public class Employee {

	@Override
	public String toString() {
		return "Employee [id=" + id + ", name=" + name + ", salary=" + salary + ", department=" + department + "]";
	}

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "ID")
	@ApiModelProperty(notes = "Id of the employee")
	private Long id;

	@Column(name = "EMPLOYEE_NAME")
	@NotNull
	@ApiModelProperty(notes = "Name of the employee")
	private String name;

	@Column(name = "EMPLOYEE_SALARY")
	@NotNull
	@ApiModelProperty(notes = "Salary of the employee")
	private Integer salary;

	@Column(name = "DEPARTMENT")
	@NotNull
	@ApiModelProperty(notes = "Department of the employee")
	private String department;

	public Employee() {
		super();
	}

	public Employee(Long id, String name, Integer salary, String department) {
		this.id = id;
		this.name = name;
		this.salary = salary;
		this.department = department;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getSalary() {
		return salary;
	}

	public void setSalary(Integer salary) {
		this.salary = salary;
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	@Override
	public int hashCode() {
		return Objects.hash(department, id, name, salary);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Employee other = (Employee) obj;
		return Objects.equals(department, other.department) && Objects.equals(id, other.id)
				&& Objects.equals(name, other.name) && Objects.equals(salary, other.salary);
	}
}
