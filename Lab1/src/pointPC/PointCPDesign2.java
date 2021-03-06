//SEG2105-A1
//6312215 - Jolayemioluwa Ilori
//7997484 - Karen Santos

package pointPC;

// This file contains material supporting section 2.9 of the textbook:
// "Object Oriented Software Engineering" and is issued under the open-source
// license found at www.lloseng.com 

/**
 * This class contains instances of coordinates in polar format. Does not
 * provides the utilities to convert them into the other type but it can receive
 * both types to create an instance. 
 *
 * @author Jolayemioluwa Ilori
 * @author Karen Santos
 * @version September 2014
 */
public class PointCPDesign2 {
	// Instance variables ************************************************

	/**
	 * Contains C(artesian) or P(olar) to identify the type of coordinates that
	 * are being dealt with.
	 */
	private char typeCoord;

	/**
	 * Contains the current value of X or RHO depending on the type of
	 * coordinates.
	 */
	private double rho;

	/**
	 * Contains the current value of Y or THETA value depending on the type of
	 * coordinates.
	 */
	private double theta;

	// Constructors ******************************************************

	/**
	 * Constructs a coordinate object, with a type identifier.
	 */
	public PointCPDesign2(char type, double xOrRho, double yOrTheta) {
		if (type != 'C' && type != 'P')
			throw new IllegalArgumentException();
		if (type == 'C') {
			this.rho = (Math.sqrt(Math.pow(xOrRho, 2) + Math.pow(yOrTheta, 2)));
			this.theta = Math.toDegrees(Math.atan2(yOrTheta, xOrRho));
		} else {
			this.rho = xOrRho;
			this.theta = yOrTheta;
		}
		this.typeCoord = type;
	}

	// Instance methods **************************************************

	public double getX() {
		return (Math.cos(Math.toRadians(theta)) * rho);
	}

	public double getY() {
		return (Math.sin(Math.toRadians(theta)) * rho);
	}

	public double getRho() {
		return rho;
	}

	public double getTheta() {
		return theta;
	}

	/**
	 * Converts Cartesian coordinates to Polar coordinates.
	 */
	public void convertStorageToPolar() {
	}

	/**
	 * Converts Polar coordinates to Cartesian coordinates.
	 */
	public void convertStorageToCartesian() {
	}

	/**
	 * Calculates the distance in between two points using the Pythagorean
	 * theorem (C ^ 2 = A ^ 2 + B ^ 2). Not needed until E2.30.
	 *
	 * @param pointA
	 *            The first point.
	 * @param pointB
	 *            The second point.
	 * @return The distance between the two points.
	 */
	public double getDistance(PointCPDesign2 pointB) {
		// Obtain differences in X and Y, sign is not important as these values
		// will be squared later.
		double deltaX = getX() - pointB.getX();
		double deltaY = getY() - pointB.getY();

		return Math.sqrt((Math.pow(deltaX, 2) + Math.pow(deltaY, 2)));
	}

	/**
	 * Rotates the specified point by the specified number of degrees. Not
	 * required until E2.30
	 *
	 * @param point
	 *            The point to rotate
	 * @param rotation
	 *            The number of degrees to rotate the point.
	 * @return The rotated image of the original point.
	 */
	public PointCPDesign2 rotatePoint(double rotation) {
		double radRotation = Math.toRadians(rotation);
		double X = getX();
		double Y = getY();

		return new PointCPDesign2('C', (Math.cos(radRotation) * X)
				- (Math.sin(radRotation) * Y), (Math.sin(radRotation) * X)
				+ (Math.cos(radRotation) * Y));
	}

	@Override
	public String toString() {
		if (typeCoord == 'C') {
			return "[" + getX() + ", " + getY() + "]";
		} else {
			return "[" + getRho() + ", " + getTheta() + "]";
		}
	}

	/**
	 * Returns information about the coordinates.
	 *
	 * @return A String containing information about the coordinates.
	 */
	public String toString(char type) {
		if (type == 'C' || type == 'c') {
			return "Stored as Polar, but converting to Cartesian you have ["
					+ getX() + ", " + getY() + "]";
		} else {
			return "Stored as " + "Polar [" + getRho() + ", " + getTheta()
					+ "]" + "\n";
		}
	}
}
