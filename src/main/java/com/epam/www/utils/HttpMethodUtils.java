package com.epam.www.utils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.StringWriter;

import com.epam.www.constants.CommonConstants;

public class HttpMethodUtils {

	public static int getContentLength(BufferedReader rq) throws IOException {
		String stringForRead = "";
		String contLength = "";

		do {
			if (stringForRead.contains(CommonConstants.CONTENT_LENGTH)) {
				contLength = stringForRead;
				break;
			}
		} while ((stringForRead = rq.readLine()) != null);

		return Integer.parseInt(SplitUtils.getLastSplitValueBy(contLength, CommonConstants.COLON_SPLITTER));
	}

	public static String getPostBody(BufferedReader rq) throws IOException {

		StringWriter postRequest = new StringWriter();
		char[] buffer = new char[1024];
		int n = 0;
		while ((n = rq.read(buffer)) != -1) {
			postRequest.write(buffer, 0, n);
			break;
		}
		return SplitUtils.getLastSplitValueBy(postRequest.toString(), CommonConstants.NEW_LINE);
	}
}
