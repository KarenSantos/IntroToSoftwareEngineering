//SEG2105-A1
//6312215 - Jolayemioluwa Ilori
//7997484 - Karen Santos

package pointPC;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

/**
 * This class creates random instances of the 3 PointCP designs and calls each
 * method many thousands of times, to make a performance analysis comparing the
 * elapsed time for each.
 *
 * @author Jolayemioluwa Ilori
 * @author Karen Santos
 * @version September 2014
 */
public class PerformanceAnalysis {

	/**
	 * Contains the randomly generated coordinate type.
	 */
	private static char type;

	/**
	 * Contains the randomly generated first coordinate of the point.
	 */
	private static double coord1;

	/**
	 * Contains the randomly generated second coordinate of the point.
	 */
	private static double coord2;

	/**
	 * Contains the two different types of coordinates, C(artesian) and P(olar).
	 */
	private static List<Character> coordTypes = new ArrayList<Character>();

	/**
	 * Contains the random generator used to create random instances of the
	 * PointPC designs.
	 */
	private static Random randomGenerator = new Random();

	private final static int RUNNING_TIMES = 5;
	private final static int RUNNING_TIMES_EACH = 1000000;

	public static void main(String[] args) {

		coordTypes.add('C');
		coordTypes.add('P');

		// CREATING RANDOM INSTANCES
		List<Long> valuesD1Instances = new ArrayList<Long>();
		List<Long> valuesD2Instances = new ArrayList<Long>();
		List<Long> valuesD4Instances = new ArrayList<Long>();
		
		System.out.println("Each method was called " + RUNNING_TIMES_EACH + " times.");
		System.out.println("The values were calculated from running the test " + RUNNING_TIMES + " times.\n");

		System.out.println("Generating random instances for PointCP Designs 1, 2 and 4");
		int i = 0;
		while (i < RUNNING_TIMES) {

			generateInstances(valuesD1Instances, valuesD2Instances,
					valuesD4Instances);
			i++;
		}
		System.out.println("Times in milliseconds");
		System.out.println("Design 1: Median = " + getMedian(valuesD1Instances)
				+ ", Min = " + getMin(valuesD1Instances)
				+ ", Max = " + getMax(valuesD1Instances));
		System.out.println("Design 2: Median = " + getMedian(valuesD2Instances)
				+ ", Min = " + getMin(valuesD2Instances)
				+ ", Max = " + getMax(valuesD2Instances));
		System.out.println("Design 4: Median = " + getMedian(valuesD4Instances)
				+ ", Min = " + getMin(valuesD4Instances)
				+ ", Max = " + getMax(valuesD4Instances) + "\n");

		// CALLING METHOD getX
		List<Long> valuesD1GetX = new ArrayList<Long>();
		List<Long> valuesD2GetX = new ArrayList<Long>();
		List<Long> valuesD4GetX = new ArrayList<Long>();

		System.out.println("Calling method getX for Design 1, 2 and 4");
		i = 0;
		while (i < RUNNING_TIMES) {

			callingMethodGetX(valuesD1GetX, valuesD2GetX, valuesD4GetX);
			i++;

		}
		System.out.println("Times in milliseconds");
		System.out.println("Design 1: Median = " + getMedian(valuesD1GetX)
				+ ", Min = " + getMin(valuesD1GetX)
				+ ", Max = " + getMax(valuesD1GetX));
		System.out.println("Design 2: Median = " + getMedian(valuesD2GetX)
				+ ", Min = " + getMin(valuesD2GetX)
				+ ", Max = " + getMax(valuesD2GetX));
		System.out.println("Design 4: Median = " + getMedian(valuesD4GetX)
				+ ", Min = " + getMin(valuesD4GetX)
				+ ", Max = " + getMax(valuesD4GetX) + "\n");

		// CALLING METHOD getY
		List<Long> valuesD1GetY = new ArrayList<Long>();
		List<Long> valuesD2GetY = new ArrayList<Long>();
		List<Long> valuesD4GetY = new ArrayList<Long>();

		System.out.println("Calling method getY for Design 1, 2 and 4");
		i = 0;
		while (i < RUNNING_TIMES) {

			callingMethodGetY(valuesD1GetY, valuesD2GetY, valuesD4GetY);
			i++;

		}
		System.out.println("Times in milliseconds");
		System.out.println("Design 1: Median = " + getMedian(valuesD1GetY)
				+ ", Min = " + getMin(valuesD1GetY)
				+ ", Max = " + getMax(valuesD1GetY));
		System.out.println("Design 2: Median = " + getMedian(valuesD2GetY)
				+ ", Min = " + getMin(valuesD2GetY)
				+ ", Max = " + getMax(valuesD2GetY));
		System.out.println("Design 4: Median = " + getMedian(valuesD4GetY)
				+ ", Min = " + getMin(valuesD4GetY)
				+ ", Max = " + getMax(valuesD4GetY) + "\n");

		// CALLING METHOD getRho
		List<Long> valuesD1GetRho = new ArrayList<Long>();
		List<Long> valuesD2GetRho = new ArrayList<Long>();
		List<Long> valuesD4GetRho = new ArrayList<Long>();

		System.out.println("Calling method getRho for Design 1, 2 and 4");
		i = 0;
		while (i < RUNNING_TIMES) {

			callingMethodGetRho(valuesD1GetRho, valuesD2GetRho, valuesD4GetRho);
			i++;

		}
		System.out.println("Times in milliseconds");
		System.out.println("Design 1: Median = " + getMedian(valuesD1GetRho)
				+ ", Min = " + getMin(valuesD1GetRho)
				+ ", Max = " + getMax(valuesD1GetRho));
		System.out.println("Design 2: Median = " + getMedian(valuesD2GetRho)
				+ ", Min = " + getMin(valuesD2GetRho)
				+ ", Max = " + getMax(valuesD2GetRho));
		System.out.println("Design 4: Median = " + getMedian(valuesD4GetRho)
				+ ", Min = " + getMin(valuesD4GetRho)
				+ ", Max = " + getMax(valuesD4GetRho) + "\n");

		// CALLING METHOD getTheta
		List<Long> valuesD1GetTheta = new ArrayList<Long>();
		List<Long> valuesD2GetTheta = new ArrayList<Long>();
		List<Long> valuesD4GetTheta = new ArrayList<Long>();

		System.out.println("Calling method getTheta for Design 1, 2 and 4");
		i = 0;
		while (i < RUNNING_TIMES) {

			callingMethodGetTheta(valuesD1GetTheta, valuesD2GetTheta,
					valuesD4GetTheta);
			i++;

		}
		System.out.println("Times in milliseconds");
		System.out.println("Design 1: Median = " + getMedian(valuesD1GetTheta)
				+ ", Min = " + getMin(valuesD1GetTheta)
				+ ", Max = " + getMax(valuesD1GetTheta));
		System.out.println("Design 2: Median = " + getMedian(valuesD2GetTheta)
				+ ", Min = " + getMin(valuesD2GetTheta)
				+ ", Max = " + getMax(valuesD2GetTheta));
		System.out.println("Design 4: Median = " + getMedian(valuesD4GetTheta)
				+ ", Min = " + getMin(valuesD4GetTheta)
				+ ", Max = " + getMax(valuesD4GetTheta) + "\n");

		// CALLING METHOD getDistance
		List<Long> valuesD1GetDistance = new ArrayList<Long>();
		List<Long> valuesD2GetDistance = new ArrayList<Long>();
		List<Long> valuesD4GetDistance = new ArrayList<Long>();

		System.out.println("Calling method getDistance for Design 1, 2 and 4");
		i = 0;
		while (i < RUNNING_TIMES) {

			callingMethodGetDistance(valuesD1GetDistance, valuesD2GetDistance,
					valuesD4GetDistance);
			i++;

		}
		System.out.println("Times in milliseconds");
		System.out.println("Design 1: Median = " + getMedian(valuesD1GetDistance)
				+ ", Min = " + getMin(valuesD1GetDistance)
				+ ", Max = " + getMax(valuesD1GetDistance));
		System.out.println("Design 2: Median = " + getMedian(valuesD2GetDistance)
				+ ", Min = " + getMin(valuesD2GetDistance)
				+ ", Max = " + getMax(valuesD2GetDistance));
		System.out.println("Design 4: Median = " + getMedian(valuesD4GetDistance)
				+ ", Min = " + getMin(valuesD4GetDistance)
				+ ", Max = " + getMax(valuesD4GetDistance) + "\n");

		// CALLING METHOD rotatePoint
		List<Long> valuesD1rotatePoint = new ArrayList<Long>();
		List<Long> valuesD2rotatePoint = new ArrayList<Long>();
		List<Long> valuesD4rotatePoint = new ArrayList<Long>();

		System.out.println("Calling method rotatePoint for Design 1, 2 and 4");
		i = 0;
		while (i < RUNNING_TIMES) {

			callingMethodRotatePoint(valuesD1rotatePoint, valuesD2rotatePoint,
					valuesD4rotatePoint);
			i++;

		}
		System.out.println("Times in milliseconds");
		System.out.println("Design 1: Median = " + getMedian(valuesD1rotatePoint)
				+ ", Min = " + getMin(valuesD1rotatePoint)
				+ ", Max = " + getMax(valuesD1rotatePoint));
		System.out.println("Design 2: Median = " + getMedian(valuesD2rotatePoint)
				+ ", Min = " + getMin(valuesD2rotatePoint)
				+ ", Max = " + getMax(valuesD2rotatePoint));
		System.out.println("Design 4: Median = " + getMedian(valuesD4rotatePoint)
				+ ", Min = " + getMin(valuesD4rotatePoint)
				+ ", Max = " + getMax(valuesD4rotatePoint) + "\n");

	}

	/**
	 * This method generates many random instances of PointCP Designs 1, 2, and
	 * 4 and stores the elapsed time for each.
	 * 
	 * @param valuesDesign1
	 *            The list to store the time for Design 1.
	 * @param valuesDesign2
	 *            The list to store the time for Design 2.
	 * @param valuesDesign4
	 *            The list to store the time for Design 4.
	 */
	private static void generateInstances(List<Long> valuesDesign1,
			List<Long> valuesDesign2, List<Long> valuesDesign4) {
		long startTime = System.currentTimeMillis();
		int i = 0;
		while (i < RUNNING_TIMES_EACH) {
			generateRandomValues();
			PointCP pointD1 = new PointCP(type, coord1, coord2);
			i++;
		}
		long stopTime = System.currentTimeMillis();
		valuesDesign1.add(stopTime - startTime);

		startTime = System.currentTimeMillis();
		i = 0;
		while (i < RUNNING_TIMES_EACH) {
			generateRandomValues();
			PointCPDesign2 pointD2 = new PointCPDesign2(type, coord1, coord2);
			i++;
		}
		stopTime = System.currentTimeMillis();
		valuesDesign2.add(stopTime - startTime);

		startTime = System.currentTimeMillis();
		i = 0;
		while (i < RUNNING_TIMES_EACH) {
			generateRandomValues();
			PointCPDesign4 pointD4 = new PointCPDesign4(type, coord1, coord2);
			i++;
		}
		stopTime = System.currentTimeMillis();
		valuesDesign4.add(stopTime - startTime);
	}

	/**
	 * This method calls the method getX from each design many times and stores
	 * the elapsed time for each design.
	 * 
	 * @param valuesDesign1
	 *            The list to store the time for Design 1.
	 * @param valuesDesign2
	 *            The list to store the time for Design 2.
	 * @param valuesDesign4
	 *            The list to store the time for Design 4.
	 */
	private static void callingMethodGetX(List<Long> valuesDesign1,
			List<Long> valuesDesign2, List<Long> valuesDesign4) {

		generateRandomValues();
		PointCP pointD1 = new PointCP(type, coord1, coord2);
		PointCPDesign2 pointD2 = new PointCPDesign2(type, coord1, coord2);
		PointCPDesign4 pointD4 = new PointCPDesign4(type, coord1, coord2);

		long startTime = System.currentTimeMillis();
		int i = 0;
		while (i < RUNNING_TIMES_EACH) {
			pointD1.getX();
			i++;
		}
		long stopTime = System.currentTimeMillis();
		valuesDesign1.add(stopTime - startTime);

		startTime = System.currentTimeMillis();
		i = 0;
		while (i < RUNNING_TIMES_EACH) {
			pointD2.getX();
			i++;
		}
		stopTime = System.currentTimeMillis();
		valuesDesign2.add(stopTime - startTime);

		startTime = System.currentTimeMillis();
		i = 0;
		while (i < RUNNING_TIMES_EACH) {
			pointD4.getX();
			i++;
		}
		stopTime = System.currentTimeMillis();
		valuesDesign4.add(stopTime - startTime);
	}

	/**
	 * This method calls the method getY from each design many times and stores
	 * the elapsed time for each design.
	 * 
	 * @param valuesDesign1
	 *            The list to store the time for Design 1.
	 * @param valuesDesign2
	 *            The list to store the time for Design 2.
	 * @param valuesDesign4
	 *            The list to store the time for Design 4.
	 */
	private static void callingMethodGetY(List<Long> valuesDesign1,
			List<Long> valuesDesign2, List<Long> valuesDesign4) {

		generateRandomValues();
		PointCP pointD1 = new PointCP(type, coord1, coord2);
		PointCPDesign2 pointD2 = new PointCPDesign2(type, coord1, coord2);
		PointCPDesign4 pointD4 = new PointCPDesign4(type, coord1, coord2);

		long startTime = System.currentTimeMillis();
		int i = 0;
		while (i < RUNNING_TIMES_EACH) {
			pointD1.getY();
			i++;
		}
		long stopTime = System.currentTimeMillis();
		valuesDesign1.add(stopTime - startTime);

		startTime = System.currentTimeMillis();
		i = 0;
		while (i < RUNNING_TIMES_EACH) {
			pointD2.getY();
			i++;
		}
		stopTime = System.currentTimeMillis();
		valuesDesign2.add(stopTime - startTime);

		startTime = System.currentTimeMillis();
		i = 0;
		while (i < RUNNING_TIMES_EACH) {
			pointD4.getY();
			i++;
		}
		stopTime = System.currentTimeMillis();
		valuesDesign4.add(stopTime - startTime);
	}

	/**
	 * This method calls the method getRho from each design many times and
	 * stores the elapsed time for each design.
	 * 
	 * @param valuesDesign1
	 *            The list to store the time for Design 1.
	 * @param valuesDesign2
	 *            The list to store the time for Design 2.
	 * @param valuesDesign4
	 *            The list to store the time for Design 4.
	 */
	private static void callingMethodGetRho(List<Long> valuesDesign1,
			List<Long> valuesDesign2, List<Long> valuesDesign4) {

		generateRandomValues();
		PointCP pointD1 = new PointCP(type, coord1, coord2);
		PointCPDesign2 pointD2 = new PointCPDesign2(type, coord1, coord2);
		PointCPDesign4 pointD4 = new PointCPDesign4(type, coord1, coord2);

		long startTime = System.currentTimeMillis();
		int i = 0;
		while (i < RUNNING_TIMES_EACH) {
			pointD1.getRho();
			i++;
		}
		long stopTime = System.currentTimeMillis();
		valuesDesign1.add(stopTime - startTime);

		startTime = System.currentTimeMillis();
		i = 0;
		while (i < RUNNING_TIMES_EACH) {
			pointD2.getRho();
			i++;
		}
		stopTime = System.currentTimeMillis();
		valuesDesign2.add(stopTime - startTime);

		startTime = System.currentTimeMillis();
		i = 0;
		while (i < RUNNING_TIMES_EACH) {
			pointD4.getRho();
			i++;
		}
		stopTime = System.currentTimeMillis();
		valuesDesign4.add(stopTime - startTime);
	}

	/**
	 * This method calls the method getTheta from each design many times and
	 * stores the elapsed time for each design.
	 * 
	 * @param valuesDesign1
	 *            The list to store the time for Design 1.
	 * @param valuesDesign2
	 *            The list to store the time for Design 2.
	 * @param valuesDesign4
	 *            The list to store the time for Design 4.
	 */
	private static void callingMethodGetTheta(List<Long> valuesDesign1,
			List<Long> valuesDesign2, List<Long> valuesDesign4) {

		generateRandomValues();
		PointCP pointD1 = new PointCP(type, coord1, coord2);
		PointCPDesign2 pointD2 = new PointCPDesign2(type, coord1, coord2);
		PointCPDesign4 pointD4 = new PointCPDesign4(type, coord1, coord2);

		long startTime = System.currentTimeMillis();
		int i = 0;
		while (i < RUNNING_TIMES_EACH) {
			pointD1.getTheta();
			i++;
		}
		long stopTime = System.currentTimeMillis();
		valuesDesign1.add(stopTime - startTime);

		startTime = System.currentTimeMillis();
		i = 0;
		while (i < RUNNING_TIMES_EACH) {
			pointD2.getTheta();
			i++;
		}
		stopTime = System.currentTimeMillis();
		valuesDesign2.add(stopTime - startTime);

		startTime = System.currentTimeMillis();
		i = 0;
		while (i < RUNNING_TIMES_EACH) {
			pointD4.getTheta();
			i++;
		}
		stopTime = System.currentTimeMillis();
		valuesDesign4.add(stopTime - startTime);
	}

	/**
	 * This method calls the method getDistance from each design many times and
	 * stores the elapsed time for each design.
	 * 
	 * @param valuesDesign1
	 *            The list to store the time for Design 1.
	 * @param valuesDesign2
	 *            The list to store the time for Design 2.
	 * @param valuesDesign4
	 *            The list to store the time for Design 4.
	 */
	private static void callingMethodGetDistance(List<Long> valuesDesign1,
			List<Long> valuesDesign2, List<Long> valuesDesign4) {

		generateRandomValues();
		PointCP pointD1a = new PointCP(type, coord1, coord2);
		PointCPDesign2 pointD2a = new PointCPDesign2(type, coord1, coord2);
		PointCPDesign4 pointD4a = new PointCPDesign4(type, coord1, coord2);

		generateRandomValues();
		PointCP pointD1b = new PointCP(type, coord1, coord2);
		PointCPDesign2 pointD2b = new PointCPDesign2(type, coord1, coord2);
		PointCPDesign4 pointD4b = new PointCPDesign4(type, coord1, coord2);

		long startTime = System.currentTimeMillis();
		int i = 0;
		while (i < RUNNING_TIMES_EACH) {
			pointD1a.getDistance(pointD1b);
			i++;
		}
		long stopTime = System.currentTimeMillis();
		valuesDesign1.add(stopTime - startTime);

		startTime = System.currentTimeMillis();
		i = 0;
		while (i < RUNNING_TIMES_EACH) {
			pointD2a.getDistance(pointD2b);
			i++;
		}
		stopTime = System.currentTimeMillis();
		valuesDesign2.add(stopTime - startTime);

		startTime = System.currentTimeMillis();
		i = 0;
		while (i < RUNNING_TIMES_EACH) {
			pointD4a.getDistance(pointD4b);
			i++;
		}
		stopTime = System.currentTimeMillis();
		valuesDesign4.add(stopTime - startTime);
	}

	/**
	 * This method calls the method rotatePoint from each design many times and
	 * stores the elapsed time for each design.
	 * 
	 * @param valuesDesign1
	 *            The list to store the time for Design 1.
	 * @param valuesDesign2
	 *            The list to store the time for Design 2.
	 * @param valuesDesign4
	 *            The list to store the time for Design 4.
	 */
	private static void callingMethodRotatePoint(List<Long> valuesDesign1,
			List<Long> valuesDesign2, List<Long> valuesDesign4) {

		generateRandomValues();
		PointCP pointD1 = new PointCP(type, coord1, coord2);
		PointCPDesign2 pointD2 = new PointCPDesign2(type, coord1, coord2);
		PointCPDesign4 pointD4 = new PointCPDesign4(type, coord1, coord2);
		double rotatingDegrees = randomGenerator.nextDouble();

		long startTime = System.currentTimeMillis();
		int i = 0;
		while (i < RUNNING_TIMES_EACH) {
			pointD1.rotatePoint(rotatingDegrees);
			i++;
		}
		long stopTime = System.currentTimeMillis();
		valuesDesign1.add(stopTime - startTime);

		startTime = System.currentTimeMillis();
		i = 0;
		while (i < RUNNING_TIMES_EACH) {
			pointD2.rotatePoint(rotatingDegrees);
			i++;
		}
		stopTime = System.currentTimeMillis();
		valuesDesign2.add(stopTime - startTime);

		startTime = System.currentTimeMillis();
		i = 0;
		while (i < RUNNING_TIMES_EACH) {
			pointD4.rotatePoint(rotatingDegrees);
			i++;
		}
		stopTime = System.currentTimeMillis();
		valuesDesign4.add(stopTime - startTime);
	}

	/**
	 * Returns the median value of a list of long values.
	 * 
	 * @param values
	 *            The list of long values.
	 * @return The median value of the list.
	 */
	private static Long getMedian(List<Long> values) {
		Collections.sort(values);
		int half = values.size()/2;	
		return values.get(half);
	}

	/**
	 * Returns the minimum value of a list of long values.
	 * 
	 * @param values
	 *            The list of long values.
	 * @return The minimum value of the list.
	 */
	private static long getMin(List<Long> values) {
		Collections.sort(values);
		return values.get(0);
	}

	/**
	 * Returns the maximum value of a list of long values.
	 * 
	 * @param values
	 *            The list of long values.
	 * @return The maximum value of the list.
	 */
	private static long getMax(List<Long> values) {
		Collections.sort(values);
		return values.get(values.size() - 1);
	}

	/**
	 * Generates random values for the coordinate type and the two coordinates.
	 */
	private static void generateRandomValues() {
		type = coordTypes.get(randomGenerator.nextInt(coordTypes.size()));
		coord1 = randomGenerator.nextInt(10) + randomGenerator.nextDouble();
		coord2 = randomGenerator.nextInt(10) + randomGenerator.nextDouble();

	}

}
