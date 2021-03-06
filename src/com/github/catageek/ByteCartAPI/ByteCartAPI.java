package com.github.catageek.ByteCartAPI;

import java.util.logging.Logger;

import com.github.catageek.ByteCartAPI.AddressLayer.Resolver;


public final class ByteCartAPI {

	private static ByteCartPlugin plugin;
	public static final int MAXSTATION = 256;
	public static final int MAXSTATIONLOG = 8;
	public static final int MAXRING = 2048;
	public static final int MAXRINGLOG = 11;

	/**
	 * @return the plugin
	 */
	public static ByteCartPlugin getPlugin() {
		return plugin;
	}

	/**
	 * @param plugin the plugin to set
	 */
	public static void setPlugin(ByteCartPlugin plugin) {
		if (ByteCartAPI.plugin != null && plugin != null) {
			throw new UnsupportedOperationException("Cannot redefine singleton Plugin");
		}

		ByteCartAPI.plugin = plugin;
	}

	/**
	 * @return the resolver registered
	 */
	public static Resolver getResolver() {
		return plugin.getResolver();
	}

	/**
	 * Set the resolver that will be used
	 * 
	 * @param resolver the resolver provided
	 */
	public static void setResolver(Resolver resolver) {
		plugin.setResolver(resolver);
	}

	/**
	 * Get the logger
	 * 
	 * @return the logger
	 */
	public static Logger getLogger() {
		return plugin.getLog();
	}

}
