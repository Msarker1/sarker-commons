package com.sarker.commons.cryptography;

import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import javax.crypto.Cipher;
import javax.crypto.Mac;
import javax.crypto.spec.GCMParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import org.apache.commons.codec.binary.Base64;
import com.sarker.commons.constant.CommonsConstants;
import com.sarker.commons.model.IVKeyValuePair;

/**
 * This common class is used for cryptographic operations.
 * @author tanvir
 *
 */
public class SarkerCrypto {

	/**
	 * Used to hash messages.
	 * @param key
	 * @param message
	 * @return String of hashed message.
	 * @throws NoSuchAlgorithmException
	 * @throws InvalidKeyException
	 */
	public static String generateHmac(String key, String message) throws NoSuchAlgorithmException, InvalidKeyException {
		Mac mac = Mac.getInstance(CommonsConstants.HMAC256);
		SecretKeySpec secretKeySpec = new SecretKeySpec(key.getBytes(), CommonsConstants.HMAC256);
		mac.init(secretKeySpec);
		byte[] hmacSha256 = mac.doFinal(message.getBytes());
		return Base64.encodeBase64String(hmacSha256);
	}

	/**
	 * Used to verify hmac messages.
	 * @param message
	 * @param hashMessage
	 * @param key
	 * @return boolean of if message was not tampered with.
	 * @throws InvalidKeyException
	 * @throws NoSuchAlgorithmException
	 */
	public static boolean verifyHmac(String hashMessage, String message, String key) throws InvalidKeyException, NoSuchAlgorithmException {
		return generateHmac(key, message).equals(hashMessage);
	}

	/**
	 * This method is used to encrypt given value.
	 * @param value
	 * @return IVKeyValuePair of encrypted value in Base64 form.
	 * @throws Exception 
	 */
	public static IVKeyValuePair encrypt(String value) throws Exception {
		if(value == null) {
			throw new Exception("value is null");
		}
		byte [] key = new byte[32];
		byte [] iv = new byte[16];
		SecureRandom random = new SecureRandom();
		random.nextBytes(iv);
		random.nextBytes(key);
		Cipher cipher = Cipher.getInstance(CommonsConstants.GCM);
		SecretKeySpec keySpec = new SecretKeySpec(key, CommonsConstants.AES);
		GCMParameterSpec gcm = new GCMParameterSpec(96, iv);
		cipher.init(Cipher.ENCRYPT_MODE, keySpec, gcm);
		byte [] encrypted = cipher.doFinal(value.getBytes());
		return new IVKeyValuePair(iv, key, encrypted);
	}

	/**
	 * This method uses predefined parsing to decrypt given value.
	 * Expectation is iv is concatenated with '@' with encrypted value.
	 * @param value
	 * @param key
	 * @return String of decrypted value.
	 * @throws Exception 
	 */
	public static String regexDecrypt(String value, String key) throws Exception {
		if(value == null || key == null) {
			throw new Exception("value or key is null");
		}
		String[] valueArr = value.split(CommonsConstants.PARSER);
		String parsedIV = valueArr[0];
		String parsedValue = valueArr[1];
		return decrypt(new IVKeyValuePair(parsedIV, key, parsedValue));
	}

	/**
	 * This method converts IVKeyValuePair from Base64 into byte arrays and decrypts given value.
	 * Use <p>{@code decrypt(byte[] encrypted, byte[] iv, byte[] key) throws Exception} </p>
	 * directly if values of object are not in Base64 form.
	 * @param ikv
	 * @return String of decrypted value.
	 * @throws Exception 
	 */
	public static String decrypt(IVKeyValuePair ikv) throws Exception {
		if(ikv == null) {
			throw new Exception("ikv is null");
		}
		byte[] encrypted = java.util.Base64.getDecoder().decode(ikv.getValue());
		byte[] iv = java.util.Base64.getDecoder().decode(ikv.getIv());
		byte[] key = java.util.Base64.getDecoder().decode(ikv.getKey());
		return decrypt(encrypted, iv, key);
	}

	/**
	 * This method decrypts given value.
	 * @param encrypted
	 * @param iv
	 * @param key
	 * @return String of decrypted value.
	 * @throws Exception 
	 */
	public static String decrypt(byte[] encrypted, byte[] iv, byte[] key) throws Exception {
		if(encrypted == null || iv == null || key == null) {
			throw new Exception("encrypted, iv, or key is null");
		}
		Cipher cipher = Cipher.getInstance(CommonsConstants.GCM);
		SecretKeySpec keySpec = new SecretKeySpec(key, CommonsConstants.AES);
		GCMParameterSpec gcm = new GCMParameterSpec(96, iv);
		cipher.init(Cipher.DECRYPT_MODE, keySpec, gcm);
		byte [] decrypted = cipher.doFinal(encrypted);
		return new String(decrypted);
	}
}
