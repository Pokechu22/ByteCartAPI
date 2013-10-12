package com.github.catageek.ByteCartAPI.Signs;


/**
 * A router
 */
public interface BCRouter extends BCSign {
	/**
	 * Get the track from where the cart is coming.
	 * 
	 * For a region router, the returned value is the ring number.
	 * 
	 * For a backbone router, the returned value is the region number.
	 *
	 * @return the track number
	 */
	public int getOriginTrack();

	public com.github.catageek.ByteCartAPI.Wanderer.RoutingTable getRoutingTable();
}
