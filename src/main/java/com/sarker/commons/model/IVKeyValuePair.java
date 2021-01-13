package com.sarker.commons.model;

import org.apache.commons.codec.binary.Base64;

/**
 * This class is used to hold iv, key, and value as an object.
 * Object values is expected to be converted in Base64.
 * @author tanvir
 *
 */
public class IVKeyValuePair {

	private String iv;
	private String key;
	private String value;

	/**
	 * Constructor for bytes arrays.
	 * @param iv
	 * @param Key
	 * @param value
	 */
	public IVKeyValuePair(byte[] IV, byte[] keyValue , byte[] encryptedValue) {
		this.iv = java.util.Base64.getEncoder().encodeToString(IV);
		this.key = java.util.Base64.getEncoder().encodeToString(keyValue);
		this.value = java.util.Base64.getEncoder().encodeToString(encryptedValue);
	}

	/**
	 * Constructor for Strings already in Base64.
	 * @param ivBase64
	 * @param keyBase64
	 * @param encryptedValueBase64
	 * @throws Exception 
	 */
	public IVKeyValuePair(String ivBase64, String keyBase64, String encryptedValueBase64) throws Exception {
		if(Base64.isBase64(ivBase64) && Base64.isBase64(keyBase64) && Base64.isBase64(encryptedValueBase64)) {
			this.iv = ivBase64;
			this.key = keyBase64;
			this.value = encryptedValueBase64;
		} else {
			throw new Exception("Strings are not in Base64");
		}
	}

	/**
	 * @return the iv
	 */
	public String getIv() {
		return iv;
	}

	/**
	 * @return the key
	 */
	public String getKey() {
		return key;
	}

	/**
	 * @return the value
	 */
	public String getValue() {
		return value;
	}

	@Override
	public String toString() {
		return "IVKeyValuePair [iv=" + iv + ", key=" + key + ", value=" + value + "]";
	}
}
