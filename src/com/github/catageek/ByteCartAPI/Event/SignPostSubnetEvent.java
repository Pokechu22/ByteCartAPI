package com.github.catageek.ByteCartAPI.Event;

import org.bukkit.event.HandlerList;

import com.github.catageek.ByteCartAPI.CollisionManagement.IntersectionSide.Side;
import com.github.catageek.ByteCartAPI.Signs.BCSign;
import com.github.catageek.ByteCartAPI.Signs.Subnet;

/**
 * Event triggered when a vehicle is using a subnet sign,
 * after the collision avoidance layer operations.
 * 
 * The direction is definitive.
 */
public class SignPostSubnetEvent extends BCRoutableSignEvent {

	/**
	 * Default constructor
	 * 
	 * The side parameter may be:
	 * - LEFT: the vehicle will not enter the subnet OR will not leave the subnet if it was inside
	 * - RIGHT: the vehicle enters the subnet OR leaves the subnet if it was inside
	 * 
	 * @param subnet The BC9XXX sign involved
	 * @param side The direction taken by the vehicle
	 */
	public SignPostSubnetEvent(Subnet subnet, Side side) {
		super(subnet);
		this.subnet = subnet;
		this.side = side;
	}

	
	protected final Subnet subnet;
    protected Side side;
	private static final HandlerList handlers = new HandlerList();

	public HandlerList getHandlers() {
        return handlers;
	}

	public static HandlerList getHandlerList() {
        return handlers;
    }
	
	/* (non-Javadoc)
	 * @see com.github.catageek.ByteCartAPI.Event.BCSignEvent#getSign()
	 */
	@Override
	protected BCSign getSign() {
		return subnet;
	}

	/**
	 * Get the direction taken by the vehicle
	 *
	 * @return A value from IntersectionSide.Side enum
	 */
	public Side getSide() {
		return side;
	}
	
	/**
	 * Get the mask of the subnet.
	 * 
	 * Possible values are:
	 * 	- 0: No mask (BC9000)
	 *  - 5: 8-station subnet (BC9008)
	 *  - 6: 4-station subnet (BC9004)
	 *  - 7: 2-station subnet (BC9002)
	 *  - 8: station (BC9001)
	 *
	 * @return The mask of the subnet
	 */
	public int getNetmask() {
		return subnet.getNetmask();
	}

}
