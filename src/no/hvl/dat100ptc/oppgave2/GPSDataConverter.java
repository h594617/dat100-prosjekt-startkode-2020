package no.hvl.dat100ptc.oppgave2;

import no.hvl.dat100ptc.TODO;
import no.hvl.dat100ptc.oppgave1.GPSPoint;

public class GPSDataConverter {
	private static int TIME_STARTINDEX = 11; // startindex for tidspunkt i timestr

	public static int toSeconds(String timestr) {
		int hr, min, sec;
		int secs = 0;
		
		// TODO
		// OPPGAVE - START
		secs += Integer.parseInt(timestr.substring(TIME_STARTINDEX, 13))*60*60;
		secs += Integer.parseInt(timestr.substring(14, 16))*60;
		secs += Integer.parseInt(timestr.substring(17, 19));
		
		return secs;
		//throw new UnsupportedOperationException(TODO.method());

		// OPPGAVE - SLUTT
		
	}

	public static GPSPoint convert(String timeStr,
			String latitudeStr, String longitudeStr,
			String elevationStr) {

		// TODO - START ;

		GPSPoint gpspoint = new GPSPoint (toSeconds(timeStr),
				Double.parseDouble(latitudeStr),
				Double.parseDouble(longitudeStr),
				Double.parseDouble(elevationStr));
		
		return gpspoint;

		
//		throw new UnsupportedOperationException(TODO.method());

		// OPPGAVE - SLUTT ;
	    
	}
	
}
