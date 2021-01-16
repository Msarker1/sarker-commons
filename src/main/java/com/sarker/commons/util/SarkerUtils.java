package com.sarker.commons.util;

/**
 * Util class for utility operations.
 * @author tanvir
 *
 */
public class SarkerUtils {

	/**
	 * This method checks if given string is empty, null, or contains whitespace.
	 * @param value
	 * @return boolean of if any of the condition is true.
	 */
	public static boolean isEmpty(String value) {
		if((value == null) || (value.length() == 0))
			return true;
		for(char charValue : value.toCharArray()) {
			if(!Character.isWhitespace(charValue)) {
				return false;
			}
		}
		return true;
	}
}
