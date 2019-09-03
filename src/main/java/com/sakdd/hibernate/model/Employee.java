package com.sakdd.hibernate.model;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@Entity
@Table(name = "tbl_employee")
@ApiModel(description = "Employee Object", value="Employee")
public class Employee {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="employee_id")
	@ApiModelProperty(notes = "The database generated employee Id", dataType="Integer")
	private Integer employeeId;
	@Column(name="employee_name")
	@ApiModelProperty(notes = "Name of the Employee", dataType="String")
	private String employeeName;
	@Column(name="gender")
	@ApiModelProperty(notes = "Gender of the Employee", dataType="String")
	private String gender;
	@Column(name="department")
	@ApiModelProperty(notes = "Department of the Employee", dataType="String")
	private String department;
	@Column(name="dob")
	@ApiModelProperty(notes = "Date Of Birth of the Employee", dataType = "Date")
	private Date dob;
	public Integer getEmployeeId() {
		return employeeId;
	}
	public void setEmployeeId(Integer employeeId) {
		this.employeeId = employeeId;
	}
	public String getEmployeeName() {
		return employeeName;
	}
	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getDepartment() {
		return department;
	}
	public void setDepartment(String department) {
		this.department = department;
	}
	public Date getDob() {
		return dob;
	}
	public void setDob(Date dob) {
		this.dob = dob;
	}
	public Employee(Integer employeeId, String employeeName, String gender, String department, Date dob) {
		super();
		this.employeeId = employeeId;
		this.employeeName = employeeName;
		this.gender = gender;
		this.department = department;
		this.dob = dob;
	}
	public Employee() {
		super();
		// TODO Auto-generated constructor stub
	}

	

}
