package com.sakdd.hibernate.controller;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.sakdd.hibernate.dto.RestApiResponse;
import com.sakdd.hibernate.model.Employee;
import com.sakdd.hibernate.service.EmployeeService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponses;
import io.swagger.annotations.ApiResponse;

@RestController
@RequestMapping("/api")
@Api(value="Employee Management", description="Operations pertaining to employees in Employee Management System")
public class EmployeeController {

	private static final Logger logger = LogManager.getLogger(EmployeeController.class);	
	@Autowired
	private EmployeeService employeeService;

	@ApiOperation(value = "Save an employee", response = RestApiResponse.class)
	@ApiResponses(value = {
	        @ApiResponse(code = 200, message = "Successfully saved the employee"),
	        @ApiResponse(code = 401, message = "You are not authorized to view the resource"),
	        @ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
	        @ApiResponse(code = 404, message = "The resource you were trying to reach is not found"),
	        @ApiResponse(code = 417, message = "Expectation Failed"),
	        @ApiResponse(code = 500, message = "Internal Server Error")
	        
	})
	@RequestMapping(value="/employee",method=RequestMethod.POST, produces = {"application/json"}, consumes = {"application/json"})
	public ResponseEntity<RestApiResponse> saveEmployee(@ApiParam(value = "Employee Object", required = true) @RequestBody Employee employeeObj) {
		RestApiResponse response = new RestApiResponse();
		try {
			
			if (logger.isDebugEnabled()) {
	            logger.debug("Hello from Log4j 2 - num : {}");
	        }

			Employee savedEmployee = employeeService.saveEmployee(employeeObj);
			if (savedEmployee != null) {
				response.setData(savedEmployee);
				response.setSuccess(true);
				response.setException(false);
				response.setMessage("Employee saved");
				return new ResponseEntity<RestApiResponse>(response, HttpStatus.OK);
			} else {
				response.setData(savedEmployee);
				response.setSuccess(false);
				response.setException(false);
				response.setMessage("Employee not saved");
				return new ResponseEntity<RestApiResponse>(response, HttpStatus.EXPECTATION_FAILED);
			}
		} catch (Exception ex) {
			response.setData(null);
			response.setSuccess(false);
			response.setException(true);
			response.setMessage(ex.getMessage());
			return new ResponseEntity<RestApiResponse>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}

	@ApiOperation(value = "Get the list of employees", response = RestApiResponse.class)
	@ApiResponses(value = {
	        @ApiResponse(code = 200, message = "Successfully fetched the employees"),
	        @ApiResponse(code = 401, message = "You are not authorized to view the resource"),
	        @ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
	        @ApiResponse(code = 404, message = "The resource you were trying to reach is not found"),
	        @ApiResponse(code = 417, message = "Expectation Failed"),
	        @ApiResponse(code = 500, message = "Internal Server Error")
	        
	})
	@RequestMapping(value="/employee",method=RequestMethod.GET, produces = {"application/json"})
	public ResponseEntity<RestApiResponse> getEmployees() {
		RestApiResponse response = new RestApiResponse();
		try {
			List<Employee> employees = employeeService.getEmployees();
			if (!employees.isEmpty()) {
				response.setData(employees);
				response.setSuccess(true);
				response.setException(false);
				response.setMessage("Employees found");
				return new ResponseEntity<RestApiResponse>(response, HttpStatus.OK);
			} else {
				response.setData(employees);
				response.setSuccess(false);
				response.setException(false);
				response.setMessage("Employees not found");
				return new ResponseEntity<RestApiResponse>(response, HttpStatus.EXPECTATION_FAILED);
			}

		} catch (Exception ex) {
			response.setData(null);
			response.setSuccess(false);
			response.setException(true);
			response.setMessage(ex.getMessage());
			return new ResponseEntity<RestApiResponse>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}

	@ApiOperation(value = "Find an employee by Id", response = RestApiResponse.class)
	@ApiResponses(value = {
	        @ApiResponse(code = 200, message = "Successfully fetched the employee"),
	        @ApiResponse(code = 401, message = "You are not authorized to view the resource"),
	        @ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
	        @ApiResponse(code = 404, message = "The resource you were trying to reach is not found"),
	        @ApiResponse(code = 417, message = "Expectation Failed"),
	        @ApiResponse(code = 500, message = "Internal Server Error")
	})
	@RequestMapping(value="/employee/{id}",method=RequestMethod.GET, produces = {"application/json"})
	public ResponseEntity<RestApiResponse> getEmployeeById(@ApiParam(value="Id to find the employee", required=true) @PathVariable int id) {
		RestApiResponse response = new RestApiResponse();
		try {
			Employee retrievedEmployee = employeeService.getEmployeeById(id);
			if (retrievedEmployee != null) {
				response.setData(retrievedEmployee);
				response.setSuccess(true);
				response.setException(false);
				response.setMessage("Employee with id " + id + " found");
				return new ResponseEntity<RestApiResponse>(response, HttpStatus.OK);
			} else {
				response.setData(retrievedEmployee);
				response.setSuccess(false);
				response.setException(false);
				response.setMessage("Employee with id " + id + " not found");
				return new ResponseEntity<RestApiResponse>(response, HttpStatus.EXPECTATION_FAILED);
			}
		} catch (Exception ex) {
			response.setData(null);
			response.setSuccess(false);
			response.setException(true);
			response.setMessage(ex.getMessage());
			return new ResponseEntity<RestApiResponse>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}

	
	@ApiOperation(value = "Update an employee", response = RestApiResponse.class)
	@ApiResponses(value = {
	        @ApiResponse(code = 200, message = "Successfully updated the employee"),
	        @ApiResponse(code = 401, message = "You are not authorized to view the resource"),
	        @ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
	        @ApiResponse(code = 404, message = "The resource you were trying to reach is not found"),
	        @ApiResponse(code = 417, message = "Expectation Failed"),
	        @ApiResponse(code = 500, message = "Internal Server Error") 
	})
	@RequestMapping(value="/employee", method=RequestMethod.PUT, produces = {"application/json"}, consumes = {"application/json"})
	public ResponseEntity<RestApiResponse> updateEmployee(@ApiParam(value="Employee Object", required=true) @RequestBody Employee employeeObj) {
		RestApiResponse response = new RestApiResponse();
		try {
			Employee updatedEmployee = employeeService.saveEmployee(employeeObj);
			if (updatedEmployee != null) {
				response.setData(updatedEmployee);
				response.setSuccess(true);
				response.setException(false);
				response.setMessage("Employee updated");
				return new ResponseEntity<RestApiResponse>(response, HttpStatus.OK);
			} else {
				response.setData(updatedEmployee);
				response.setSuccess(false);
				response.setException(false);
				response.setMessage("Employee not updated");
				return new ResponseEntity<RestApiResponse>(response, HttpStatus.EXPECTATION_FAILED);
			}
		} catch (Exception ex) {
			response.setData(null);
			response.setSuccess(false);
			response.setException(true);
			response.setMessage(ex.getMessage());
			return new ResponseEntity<RestApiResponse>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}

	@ApiOperation(value = "Delete an employee by Id", response = RestApiResponse.class)
	@ApiResponses(value = {
	        @ApiResponse(code = 200, message = "Successfully deleted the employee"),
	        @ApiResponse(code = 401, message = "You are not authorized to view the resource"),
	        @ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
	        @ApiResponse(code = 404, message = "The resource you were trying to reach is not found"),
	        @ApiResponse(code = 417, message = "Expectation Failed"),
	        @ApiResponse(code = 500, message = "Internal Server Error") 
	})
	@RequestMapping(value="/employee/{id}", method=RequestMethod.DELETE, produces = {"application/json"})
	public ResponseEntity<RestApiResponse> deleteEmployeeById(@ApiParam(value="Id to delete the employee", required=true) @PathVariable int id) {
		RestApiResponse response = new RestApiResponse();
		try {
			boolean deleteStatus = employeeService.deleteEmployeeById(id);
			if (deleteStatus == true) {
				response.setData(null);
				response.setSuccess(true);
				response.setException(false);
				response.setMessage("Employee with id " + id + " deleted successfully");
				return new ResponseEntity<RestApiResponse>(response, HttpStatus.OK);
			} else {
				response.setData(null);
				response.setSuccess(false);
				response.setException(false);
				response.setMessage("Employee with id " + id + " not deleted ");
				return new ResponseEntity<RestApiResponse>(response, HttpStatus.EXPECTATION_FAILED);
			}

		} catch (Exception ex) {
			response.setData(null);
			response.setSuccess(false);
			response.setException(true);
			response.setMessage(ex.getMessage());
			return new ResponseEntity<RestApiResponse>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}
}
