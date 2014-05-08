package upwego;

import java.awt.geom.Point2D;
import java.util.List;
import java.util.Set;

import jgame.Context;
import jgame.GObject;
import jgame.controller.Controller;
import jgame.listener.ParentBoundsListener;

/**
 * A controller that controls an objects location based on keyboard input
 * defined by the given {@link PlatformControlScheme}. This controller cannot be
 * shared.
 * 
 * @author William Chargin
 * 
 */
public class PlatformController implements Controller {
	/**
	 * The default gravitational acceleration, in px/frame<sup>2</sup>.
	 */
	public static final double DEFAULT_GRAVITY = 1;
	/**
	 * The control scheme for this platform controller.
	 */
	private final PlatformControlScheme controlScheme;

	/**
	 * The object to be controlled by this platform controller.
	 */
	private GObject object;

	/**
	 * These two variables describe the current velocity of the player.
	 */
	private double vx, vy;

	/**
	 * The maximum horizontal movement speed.
	 */
	private double maxSpeed;

	/**
	 * The maximum jump speed.
	 */
	private double maxJump;

	/**
	 * The gravitational acceleration, in px/frame<sup>2</sup>.
	 */
	private boolean onSolidWall;
	private double gravity;
	
	private double targetX;
	private double targetY;
	private double targetHeight;
	private double targetWidth;
	private double groundObjectX;
	private double groundObjectY;
	private double groundObjectHeight;
	private double groundObjectWidth;
	private double outOfGround;

	/**
	 * Creates the controller with the given parameters. The default
	 * gravitational acceleration will be used.
	 * 
	 * @param controlScheme
	 *            the control scheme to use
	 * @param maxSpeed
	 *            the maximum horizontal speed (in px/frame)
	 * @param maxJump
	 *            the maximum jump speed (in px/frame)
	 */
	public PlatformController(PlatformControlScheme controlScheme,
			double maxSpeed, double maxJump) {
		this(controlScheme, maxSpeed, maxJump, DEFAULT_GRAVITY); // ++++++++++++++
																	// ??????????????????????????????
	}

	/**
	 * Creates the controller with the given parameters.
	 * 
	 * @param controlScheme
	 *            the control scheme to use
	 * @param maxSpeed
	 *            the maximum horizontal speed (in px/frame)
	 * @param maxJump
	 *            the maximum jump speed (in px/frame)
	 * @param gravity
	 *            the gravitation acceleration (in px/frame<sup>2</sup>)
	 */
	public PlatformController(PlatformControlScheme controlScheme,
			double maxSpeed, double maxJump, double gravity) {
		super();
		this.controlScheme = controlScheme;
		vx = vy = outOfGround = 0;
		this.maxSpeed = maxSpeed;
		this.maxJump = maxJump;
		this.gravity = gravity;
	}

	@Override
	public void controlObject(GObject target, Context context) {
		if (object == null) {
			object = target;
		} else if (object != target) {
			throw new IllegalArgumentException(
					"This PlatformController already belongs to " + object);
		}

		Set<Integer> keys = context.getKeyCodesPressed();

		
		boolean jump = false;

		for (int key : keys) {
			if (key == controlScheme.lt) {
				vx += 1;
			} else if (key == controlScheme.rt) {
				vx -= 1;
			} else if (key == controlScheme.jump) {
				jump = true;
			} else if (vx<0) {
				vx+=.1;
			} else if (vx>0) {
				vx-=.1;
			}
		}
		outOfGround = 0;
		boolean onPlatform = false;
		

		List<Platform> Platforms = context
				.getInstancesOfClass(Platform.class);

		for (Platform platform : Platforms) {
			GObject groundObject = (GObject) platform;
			if (target.hitTest(groundObject)) {
				onPlatform = true;
				break;
			}
			targetX = target.getX();
			targetY = target.getY();
			targetHeight = target.getHeight();
			targetWidth = target.getWidth();
			groundObjectX = groundObject.getX();
			groundObjectY = groundObject.getY();
			groundObjectHeight = groundObject.getHeight();
			groundObjectWidth = groundObject.getWidth();
			
			if ((targetY +    (targetHeight / 2)) < (groundObjectY + (groundObjectHeight / 2) - 50)
					&& (targetY + (targetHeight / 2)) > (groundObjectY - (groundObjectHeight / 2)) + 5) {

				if ((targetX - (targetWidth / 2)) < (groundObjectX + (groundObjectWidth / 2) - 20)
						&& (targetX + (targetWidth / 2)) > (groundObjectX - (groundObjectWidth / 2) + 20)) {

					outOfGround = -(targetY + (targetHeight / 2))
							+ (groundObjectY - (groundObjectHeight / 2));

				} else if ((targetX - (targetWidth / 2)) < (groundObjectX + (groundObjectWidth / 2))
						&& (targetX + (targetWidth / 2)) > (groundObjectX - (groundObjectWidth / 2))) {

					vx = 0;
					onPlatform = true;
				}
			}

		}
		
		
		

		if (onPlatform) {
			if (jump) {

				vy = maxJump;

			} else {
  
				vy = 0;
				

			}
		} else {
			vy += gravity;

			

			
		}
//		vx = horizontal * maxSpeed;

		target.setLocation(target.getX() - (vx*maxSpeed), target.getY() + vy+outOfGround);
		
	}
	
	
	
	

	/**
	 * Gets the current maximum jump.
	 * 
	 * @return the maximum jump, in px/frame
	 */
	public double getMaxJump() {
		return maxJump;
	}

	/**
	 * Gets the current maximum horizontal speed.
	 * 
	 * @return the maximum horizontal speed, in px/frame
	 */
	public double getMaxSpeed() {
		return maxSpeed;
	}
	
	public double getvy() {
		return vy;
	}
	public void setvy(double newvy) {
		vy=newvy;
	}

	/**
	 * Sets the new maximum jump.
	 * 
	 * @param maxJump
	 *            the maximum jump, in px/frame
	 */
	public void setMaxJump(double maxJump) {
		this.maxJump = maxJump;
	}

	/**
	 * Sets the maximum horizontal speed.
	 * 
	 * @param maxSpeed
	 *            the new maximum horizontal speed, in px/frame
	 */
	public void setMaxSpeed(double maxSpeed) {
		if (maxSpeed < 0) {
			throw new IllegalArgumentException("maxSpeed must be nonnegative: "
					+ maxSpeed);
		}
		this.maxSpeed = maxSpeed;
	}
	
	
	

}