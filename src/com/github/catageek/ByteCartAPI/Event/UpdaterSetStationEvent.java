package com.github.catageek.ByteCartAPI.Event;

import org.bukkit.event.HandlerList;

import com.github.catageek.ByteCartAPI.AddressLayer.Address;
import com.github.catageek.ByteCartAPI.Routing.Updater;

/**
 * Event triggered when a local updater modifies the address
 * of a BC9001 sign.
 */
public class UpdaterSetStationEvent extends UpdaterClearStationEvent {
	private final Address newAddress;

	/**
	 * Default constructor
	 * 
	 * @param updater The updater involved
	 * @param oldAddress The old address of the station
	 * @param newAddress The new address of the station
	 */
	public UpdaterSetStationEvent(Updater updater, Address oldAddress, Address newAddress) {
		super(updater, oldAddress);
		this.newAddress = newAddress;
	}

	private static final HandlerList handlers = new HandlerList();

	public HandlerList getHandlers() {
        return handlers;
	}

	public static HandlerList getHandlerList() {
        return handlers;
    }

	/**
	 * @return the newAddress
	 */
	public Address getNewAddress() {
		return newAddress;
	}
}
