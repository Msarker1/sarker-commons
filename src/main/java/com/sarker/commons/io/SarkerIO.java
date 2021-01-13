package com.sarker.commons.io;

import java.io.IOException;
import java.nio.charset.StandardCharsets;

import org.apache.commons.io.IOUtils;

import io.vertx.core.json.JsonObject;

/**
 * Common class for IO operations.
 * @author tanvir
 *
 */
public class SarkerIO {

	/**
	 * Used to retrieve resource as JsonObject.
	 * @param path
	 * @return JsonObject of resource.
	 * @throws IOException
	 */
	public static JsonObject readFromResource(String path) throws IOException {
		return new JsonObject(IOUtils.toString(Thread.currentThread().getClass().getClassLoader().getResourceAsStream(path),StandardCharsets.UTF_8));
	}
}
