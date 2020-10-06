package no.hvl.dat100ptc.oppgave2;

import no.hvl.dat100ptc.TODO;
import no.hvl.dat100ptc.oppgave1.GPSPoint;

public class GPSDataConverter {

	// konverter tidsinformasjon i gps data punkt til antall sekunder fra midnatt
	// dvs. ignorer information om dato og omregn tidspunkt til sekunder
	// Eksempel - tidsinformasjon (som String): 2017-08-13T08:52:26.000Z
    // skal omregnes til sekunder (som int): 8 * 60 * 60 + 52 * 60 + 26 
	
	private static int TIME_STARTINDEX = 11; // startindex for tidspunkt i timestr

	public static int toSeconds(String timestr) {
		
		int secs = Integer.parseInt(timestr.substring(TIME_STARTINDEX, 13))*60*60;
		secs += Integer.parseInt(timestr.substring(14, 16))*60;
		secs += Integer.parseInt(timestr.substring(17, 19));
		
		int hr, min, sec;
		
		return secs;

		
		// TODO
		// OPPGAVE - START
		
		
		//throw new UnsupportedOperationException(TODO.method());

		// OPPGAVE - SLUTT
		
	}

	public static GPSPoint convert(String timeStr, String latitudeStr, String longitudeStr, String elevationStr) {

		GPSPoint gpspoint = new GPSPoint (toSeconds(timeStr), Double.parseDouble(latitudeStr), Double.parseDouble(longitudeStr), Double.parseDouble(elevationStr));
		return gpspoint;

		// TODO - START ;
		
//		throw new UnsupportedOperationException(TODO.method());

		// OPPGAVE - SLUTT ;
	    
	}
	
}
