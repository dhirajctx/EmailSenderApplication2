package com.jbk.ProductManagement.Model;

public class EmailResponse {
	String token;

	public EmailResponse(String token) {
		super();
		this.token = token;
	}

	public EmailResponse() {
		super();
	}

	@Override
	public String toString() {
		return "EmailResponse [token=" + token + "]";
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

}
