package com.example.demo.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ServerResponse {
	private String status = "Success";
	private String message;
	private Object data;
	private String errorCode;
	private String errorMessage;

	public ServerResponse(Object data) {
		this.data = data;
	}

	public ServerResponse(String status, String message, Object data) {
		this.status = status;
		this.message = message;
		this.data = data;
	}

	public ServerResponse(String status, String message, String errorCode, String errorMessage) {
		this.status = status;
		this.message = message;
		this.errorCode = errorCode;
		this.errorMessage = errorMessage;
	}
}