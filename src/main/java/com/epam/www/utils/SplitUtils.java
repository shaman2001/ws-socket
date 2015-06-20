package com.epam.www.utils;

public class SplitUtils {

	public static String getLastSplitValueBy(String sourceString, String patternForSplit) {
		String lastValue = "";
		String[] content = sourceString.split(patternForSplit);

		if (content.length > 1) {
			lastValue = content[content.length - 1].trim();
		}
		return lastValue;
	}

}
