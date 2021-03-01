package com.sarker.commons.util;

import com.sarker.commons.constant.CommonsConstants;

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
	
	/**
	 * This method validates IPv4 addresses.
	 * @param s
	 * @return boolean value of given ip string.
	 */
	public static boolean isValidIPV4(String s) {
		return s.matches(CommonsConstants.IPV4regex);
	}
}
