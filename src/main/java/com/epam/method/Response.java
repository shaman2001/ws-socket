package com.epam.method;

import java.io.IOException;
import java.io.OutputStream;
import java.util.LinkedHashMap;
import java.util.Map;

import com.epam.constants.CommonConstants;
import com.epam.constants.ResponseConstants;

public class Response {

	private OutputStream os;
	private String version;
	private String statusCode;
	private String server;
	private String date;
	private String contentType;
	private String contentLength;
	private String body;

	public Response(OutputStream outputStream) {
		this.os = outputStream;
	}

	public void write() throws IOException {
		String respose = "";
		Map<String, String> responseMap = new LinkedHashMap<String, String>();
		responseMap.put(version, statusCode);
		responseMap.put(ResponseConstants.SERVER, ResponseConstants.SERVER_VALUE);
		responseMap.put(CommonConstants.CONTENT_TYPE, contentType + "\r\n");
		responseMap.put(CommonConstants.CONTENT_LENGTH, contentLength + "\r\n");
		responseMap.put(CommonConstants.CONNECTION, ResponseConstants.CONNECTION_VALUE);
		responseMap.put(ResponseConstants.BODY, body);

		for (Map.Entry<String, String> pair : responseMap.entrySet()) {
			String key = pair.getKey();
			String value = pair.getValue();
			if (key.equals(ResponseConstants.BODY)) {
				respose += value;
			} else
				respose += key + value;
		}
		os.write(respose.getBytes());
	}

	public String getVersion() {
		return version;
	}

	public void setVersion(String version) {
		this.version = version;
	}

	public String getStatusCode() {
		return statusCode;
	}

	public void setStatusCode(String statusCode) {
		this.statusCode = statusCode;
	}

	public String getServer() {
		return server;
	}

	public void setServer(String server) {
		this.server = server;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getContentType() {
		return contentType;
	}

	public void setContentType(String contentType) {
		this.contentType = contentType;
	}

	public String getContentLength() {
		return contentLength;
	}

	public void setContentLength(String contentLength) {
		this.contentLength = contentLength;
	}

	private String connection;

	public String getConnection() {
		return connection;
	}

	public void setConnection(String connection) {
		this.connection = connection;
	}

	public String getBody() {
		return body;
	}

	public void setBody(String body) {
		this.body = body;
	}

}
