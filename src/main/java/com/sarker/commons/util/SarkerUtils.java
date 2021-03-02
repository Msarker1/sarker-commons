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
	 * @param ip
	 * @return boolean value of given ip string.
	 */
	public static boolean isValidIPV4(String ip) {
		return ip.matches(CommonsConstants.IPV4REGEX);
	}
	
	/**
	 * This method validates IPv6 addresses.
	 * @param ip
	 * @return boolean value of given ip string.
	 */
	public static boolean isValidIPV6(String ip) {
		return ip.matches(CommonsConstants.IPV6REGEX);
	}
	
	/**
	 * This method validates if string is valid ip of ipv4 or ipv6
	 * @param ip
	 * @return
	 */
	public static boolean isValidIp(String ip) {
		return isValidIPV6(ip) || isValidIPV4(ip);
	}
}
