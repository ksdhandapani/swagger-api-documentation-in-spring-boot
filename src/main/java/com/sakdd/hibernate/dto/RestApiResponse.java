package com.sakdd.hibernate.dto;

public class RestApiResponse {
	private boolean isSuccess;
	private Object data;
	private boolean isException;
	private String message;

	public boolean isSuccess() {
		return isSuccess;
	}

	public void setSuccess(boolean isSuccess) {
		this.isSuccess = isSuccess;
	}

	public Object getData() {
		return data;
	}

	public void setData(Object data) {
		this.data = data;
	}

	public boolean isException() {
		return isException;
	}

	public void setException(boolean isException) {
		this.isException = isException;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public RestApiResponse(boolean isSuccess, Object data, boolean isException, String message) {
		super();
		this.isSuccess = isSuccess;
		this.data = data;
		this.isException = isException;
		this.message = message;
	}

	public RestApiResponse() {
		super();
	}

}
