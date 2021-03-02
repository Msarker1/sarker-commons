package com.sarker.commons.constant;

/**
 * Constants class.
 * @author tanvir
 *
 */
public class CommonsConstants {
	
	public static final String UNDERSCORE = "_";
	
	public static final String FILE_TYPE_JSON = ".json";
	
	public static final String PARSER = "@";
	
	public static final String GCM = "AES/GCM/NoPadding";
	
	public static final String AES = "AES";
	
	public static final String HMAC256 = "HmacSHA256";
	
	public static final String IPV4REGEX = "^((\\d)|([\\d][\\d])|([01][\\d][\\d])|([2][0-4][\\d])|([2][0-5][0-5]))\\." +
			"((\\d)|([\\d][\\d])|([01][\\d][\\d])|([2][0-4][\\d])|([2][0-5][0-5]))\\."+
			"((\\d)|([\\d][\\d])|([01][\\d][\\d])|([2][0-4][\\d])|([2][0-5][0-5]))\\."+
			"((\\d)|([\\d][\\d])|([01][\\d][\\d])|([2][0-4][\\d])|([2][0-5][0-5]))$";
	
	public static final String IPV6REGEX = "^(([0-9a-zA-Z]{1,4}\\:){7}[0-9a-zA-Z]{1,4})$";
}
