package com.sarker.commons.util;

/**
 * Util class for utility operations.
 * @author tanvir
 *
 */
public class SarkerUtils {

	/**
	 * This method checks if given string is empty, null, or contains whitespace.
	 * @param s
	 * @return boolean of if any of the condition is true.
	 */
	public static boolean isEmpty(String s) {
		if((s == null) || (s.length() == 0))
			return true;
		for(char c : s.toCharArray()) {
			if(!Character.isWhitespace(c)) {
				return false;
			}
		}
		return true;
	}
}
