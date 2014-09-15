//SEG2105-A1
//6312215 - Jolayemioluwa Ilori
//7997484 - Karen Santos

package pointPC;

// This file contains material supporting section 2.9 of the textbook:
// "Object Oriented Software Engineering" and is issued under the open-source
// license found at www.lloseng.com 

/**
 * This class contains instances of coordinates in both polar and cartesian
 * format.
 *
 * @author Jolayemioluwa Ilori
 * @author Karen Santos
 * @version September 2014
 */
public class PointCPDesign4 {
	// Instance variables ************************************************

	/**
	 * Contains C(artesian) or P(olar) to identify the type of coordinates that
	 * are being dealt with.
	 */
	private char typeCoord;

	/**
	 * Contains the current value of X
	 */
	private double x;

	/**
	 * Contains the current value of Y
	 */
	private double y;

	/**
	 * Contains the current value of RHO
	 */
	private double rho;

	/**
	 * Contains the current value of THETA
	 */
	private double theta;

	// Constructors ******************************************************

	/**
	 * Constructs a coordinate object, with a type identifier.
	 */
	public PointCPDesign4(char type, double xOrRho, double yOrTheta) {
		if (type != 'C' && type != 'P')
			throw new IllegalArgumentException();
		if (type == 'C') {
			this.x = xOrRho;
			this.y = yOrTheta;
			this.rho = Math.sqrt(Math.pow(xOrRho, 2) + Math.pow(yOrTheta, 2));
			this.theta = Math.toDegrees(Math.atan2(yOrTheta, xOrRho));
		} else {
			this.x = Math.cos(Math.toRadians(yOrTheta)) * xOrRho;
			this.y = Math.sin(Math.toRadians(yOrTheta)) * xOrRho;
			this.rho = xOrRho;
			this.theta = yOrTheta;
		}
		this.typeCoord = type;
	}

	// Instance methods **************************************************

	public double getX() {
		return x;

	}

	public double getY() {
		return y;
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
	public void convertStorageToPolar() {}

	/**
	 * Converts Polar coordinates to Cartesian coordinates.
	 */
	public void convertStorageToCartesian() {}

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
	public double getDistance(PointCPDesign4 pointB) {
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
	public PointCPDesign4 rotatePoint(double rotation) {
		double radRotation = Math.toRadians(rotation);
		double X = getX();
		double Y = getY();

		return new PointCPDesign4('C', (Math.cos(radRotation) * X)
				- (Math.sin(radRotation) * Y), (Math.sin(radRotation) * X)
				+ (Math.cos(radRotation) * Y));
	}

	public String entered() {
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
	public String toString() {
		return "Stored as Cartesian (" + getX() + ", " + getY()
				+ ") and Polar [" + getRho() + ", " + getTheta() + "]" + "\n";
	}
}
