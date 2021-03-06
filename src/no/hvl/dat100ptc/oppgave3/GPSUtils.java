package no.hvl.dat100ptc.oppgave3;

import static java.lang.Math.*;

import no.hvl.dat100ptc.TODO;
import no.hvl.dat100ptc.oppgave1.GPSPoint;

public class GPSUtils {

	public static double findMax(double[] da) {

		double max;

		max = da[0];

		for (double d : da) {
			if (d > max) {
				max = d;
			}
		}

		return max;
	}

	public static double findMin(double[] da) {

		double min;
		min = da[0];
		for (double value : da) {
			if (value < min) {
				min = value;
			}
		}
		return min;

	}

	public static double[] getLatitudes(GPSPoint[] gpspoints) {

		double[] latTab = new double[gpspoints.length];

		for (int i = 0; i < gpspoints.length; i++) {
			latTab[i] = gpspoints[i].getLatitude();
		}

		return latTab;

	}

	public static double[] getLongitudes(GPSPoint[] gpspoints) {

		// TODO - START

		double[] lonTab = new double[gpspoints.length];
		for (int i = 0; i < gpspoints.length; i++) {
			lonTab[i] = gpspoints[i].getLongitude();

		}
		return lonTab;

		// TODO - SLUTT

	}

	private static int R = 6371000; // jordens radius

	public static double distance(GPSPoint gpspoint1, GPSPoint gpspoint2) {

		double d;
		double latitude1, longitude1, latitude2, longitude2;

		// TODO - START

		latitude1 = Math.toRadians(gpspoint1.getLatitude());
		longitude1 = Math.toRadians(gpspoint1.getLongitude());

		latitude2 = Math.toRadians(gpspoint2.getLatitude());
		longitude2 = Math.toRadians(gpspoint2.getLongitude());

		double latiDiff = latitude2 - latitude1;
		double longDiff = longitude2 - longitude1;

		double a = Math.pow(Math.sin(latiDiff / 2), 2)
				+ Math.cos(latitude1) * Math.cos(latitude2) * Math.pow(Math.sin(longDiff / 2), 2);

		double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1 - a));
		d = R * c;
		return d;
		// TODO - SLUTT

	}

	public static double speed(GPSPoint gpspoint1, GPSPoint gpspoint2) {

		int secs;

		double speed;

		// TODO - START
		secs = gpspoint2.getTime() - gpspoint1.getTime();

		speed = (distance(gpspoint1, gpspoint2)) / secs *60 *60 /1000;

		return speed;

		// TODO - SLUTT

	}

	public static String formatTime(int secs) {

		String timestr;
		String TIMESEP = ":";

		// TODO - START
		int h = secs / 3600;
		int m = (secs % 3600) / 60;
		int s = (secs % 3600) % 60;

		timestr = "  " + String.format("%02d", h) + TIMESEP + String.format("%02d", m) + TIMESEP
				+ String.format("%02d", s);

		return timestr;
//		throw new UnsupportedOperationException(TODO.method());

		// TODO - SLUTT

	}

	private static int TEXTWIDTH = 10;

	public static String formatDouble(double d) {

		String str;
		System.out.println("initial " + d);
		// TODO - START
		str="      "+String.format("%.02f", d);
		System.out.println(str);
		return str;
		
		
		// TODO - SLUTT

	}
}
