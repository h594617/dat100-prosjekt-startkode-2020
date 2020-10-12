package no.hvl.dat100ptc.oppgave4;

import no.hvl.dat100ptc.TODO;
import no.hvl.dat100ptc.oppgave1.GPSPoint;
import no.hvl.dat100ptc.oppgave2.GPSData;
import no.hvl.dat100ptc.oppgave2.GPSDataConverter;
import no.hvl.dat100ptc.oppgave2.GPSDataFileReader;
import no.hvl.dat100ptc.oppgave3.GPSUtils;

public class GPSComputer {

	private GPSPoint[] gpspoints;

	public GPSComputer(String filename) {

		GPSData gpsdata = GPSDataFileReader.readGPSFile(filename);
		gpspoints = gpsdata.getGPSPoints();

	}

	public GPSComputer(GPSPoint[] gpspoints) {
		this.gpspoints = gpspoints;
	}

	public GPSPoint[] getGPSPoints() {
		return this.gpspoints;
	}

	// beregn total distances (i meter)
	public double totalDistance() {

		double distance = 0;

		// TODO - START
		for (int i = 0; i < this.gpspoints.length - 1; i++) {
			distance += GPSUtils.distance(this.gpspoints[i], this.gpspoints[i + 1]);
		}
		return distance;

		// TODO - SLUTT

	}

	// beregn totale høydemeter (i meter)
	public double totalElevation() {

		double elevation = 0.0;

		// TODO - START
		for (int i = 0; i < this.gpspoints.length-1; i++) {
			
//			System.out.println("elev " + this.gpspoints[i].getElevation());
			
			if (this.gpspoints[i+1].getElevation() - this.gpspoints[i].getElevation() > 0) {
				
				
				elevation += this.gpspoints[i+1].getElevation() - this.gpspoints[i].getElevation();
			}

//			System.out.println("cumulative climb " + elevation);
			
		}

		return elevation;

		// TODO - SLUTT

	}

	// beregn total tiden for hele turen (i sekunder)
	public int totalTime() {

		return this.gpspoints[gpspoints.length - 1].getTime() - this.gpspoints[0].getTime();


	}

	// beregn gjennomsnitshastighets mellom hver av gps punktene

	public double[] speeds() {

		// TODO - START // OPPGAVE - START
		double[] speeds = new double[gpspoints.length - 1];

		for (int i = 0; i < gpspoints.length - 1; i++) {
			speeds[i] = GPSUtils.speed(gpspoints[i], gpspoints[i + 1]);
		}
		return speeds;
		// TODO - SLUTT

	}

	public double maxSpeed() {

		double maxspeed = -1;

		// TODO - START
		double[] speedTab = speeds();

		for (int i = 0; i < gpspoints.length - 1; i++) {
			if (speedTab[i] > maxspeed) {
				maxspeed = speedTab[i];
			}
		}
		return maxspeed;

		// TODO - SLUTT
		
	}

	public double averageSpeed() {

		double average = 0;
		// TODO - START
		return average = (totalDistance() / totalTime()) * 3.6;

		// TODO - SLUTT

	}

	/*
	 * bicycling, 
	 * <10 mph, leisure, to work or for pleasure 4.0 bicycling, 
	 * general 8.0 bicycling, 
	 * 10-11.9 mph, leisure, slow, light effort 6.0 bicycling,
	 * 12-13.9 mph, leisure, moderate effort 8.0 bicycling, 
	 * 14-15.9 mph, racing or leisure, fast, vigorous effort 
	 * 10.0 bicycling, 
	 * 16-19 mph, racing/not drafting or 
	 * >19 mph drafting, very fast, racing general 12.0 bicycling, 
	 * >20 mph, racing, not drafting 16.0
	 */

	// conversion factor m/s to miles per hour
	public static double MS = 2.236936;

	// beregn kcal gitt weight og tid der kjøres med en gitt hastighet
	public double kcal(double weight, int secs, double speed) {

		double kcal;

		// MET: Metabolic equivalent of task angir (kcal x kg-1 x h-1)
		double met = 0;
		double speedmph = speed * MS;

		if 		(speedmph < 10) 					{met = 4.0;}
		else if (speedmph > 10 && speedmph <= 12) 	{met = 6.0;}
		else if (speedmph > 12 && speedmph <= 14) 	{met = 8.0;}
		else if (speedmph > 14 && speedmph <= 16) 	{met = 10.0;}
		else if (speedmph > 16 && speedmph <= 20) 	{met = 12.0;}
		else if (speedmph > 20) 					{met = 16.0;}
		
//		kcal = (weight*met)/3600.0;
		kcal = ((secs/60)*met*3.5*weight)/200;

		return kcal;
		

	}

	public double totalKcal(double weight) {
		
		double totalkcal = 0;
		// TODO - START

		totalkcal = kcal(weight, totalTime(), averageSpeed());
		
		return totalkcal;

		// TODO - SLUTT
	}

	private static double WEIGHT = 80.0;

	public void displayStatistics() {

		System.out.println("==============================================");

		// TODO - START

		throw new UnsupportedOperationException(TODO.method());

		// TODO - SLUTT

	}

}
