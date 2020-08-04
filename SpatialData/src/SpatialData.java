/* Author: Emina Ermin Sinanovic
 * 
 * 
 * 
 */

import java.util.*;
import java.io.*;

public class SpatialData {
	
	private static Scanner input;
	private static PrintWriter outFile;
	
	public static void printHeader() {
		outFile.println("<?xml version=\"1.0\" encoding=\"UTF-8\"?>");
		outFile.println("<kml xmlns=\"http://www.opengis.net/kml/2.2\">");
		outFile.println("<Document>");
	}
	
	public static void printData(String country, String capital, String lat, String lon, String countryCode, String contName) {
		outFile.println("<Placemark>");
		outFile.println("	<Style>");
		outFile.println("		<LabelStyle>");
		outFile.println("			<scale>0</scale>");
		outFile.println("		</LabelStyle>");
		outFile.println("		<IconStyle>");
		outFile.println("			<Icon>");
		outFile.println("				<href>http://maps.google.com/mapfiles/kml/paddle/blu-circle.png</href>");
		outFile.println("			</Icon>");
		outFile.println("		</IconStyle>");	
		outFile.println("	</Style>");
		outFile.println("	<name>"+capital+"</name>");
		outFile.println("	<description>");
		outFile.println("		<![CDATA[");
		outFile.println("			<h1>"+country+"</h1>");
		outFile.println("			<ul>");
		outFile.println("				<li>Accent City = " + countryCode);
		outFile.println("				<li>Region = " + contName);
		outFile.println("			</ul>");
		outFile.println("		]]>");
		outFile.println("	</description>");
		outFile.println("	<Point>");
		outFile.println("		<coordinates>" + lon+ "," + lat+ "</coordinates>");
		outFile.println("	</Point>");
		outFile.println("</Placemark>");		
	}
	
	public static void printTail() {
		outFile.println("</Document>");
		outFile.println("</kml>");
	}
	
	public static void parsing(String in) {
		String line[] = in.split(",");
		String country = line[0];
		String capital = line[1];
		String latitude = line[2];
		String longitude = line[3];
		String countryCode = line[4];
		String continentName = line[5];
		printData(country, capital, longitude, latitude, countryCode, continentName);
	}
	
	public static void readMap(int read) {
		String str = "";
		int x = 0;
		
		str = input.nextLine();
		while(x < read) {
			str = input.nextLine();
			parsing(str);
			System.out.println(x + " = " + str);
			x++;
		}
	}

	public static void main(String[] args) throws FileNotFoundException{
		// TODO Auto-generated method stub
		input = new Scanner(new File("concap.csv"));
		outFile = new PrintWriter("worldCapital.kml");
		System.out.println("Emina Ermin Sinanovic");
		
		printHeader();
		readMap(100);
		printTail();
		
		input.close();
		outFile.close();
	}

}
