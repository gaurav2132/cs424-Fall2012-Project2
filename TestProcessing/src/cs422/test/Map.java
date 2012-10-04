package cs422.test;


import org.gicentre.geomap.GeoMap;

import processing.core.PApplet;


public class Map extends PApplet{
	/*
	  Draws a simple interactive world map that you can query.
	  It uses the giCentre's geoMap library.
	  Iain Dillingham, 20th January 2011.
	*/
	// testing the new project changes
	public static void main(String args[]) {
	    PApplet.main(new String[] { "--present", "cs422.test.GeoMap" });
	  }
	
	GeoMap geoMap;
	//GeoMap geoMap2;
	public void setup()
	{
	  size(1000, 500);
	  smooth();
	  geoMap = new GeoMap(0, 0, width, height, this);
	 // geoMap2 = new GeoMap(this);
	  
	 
	  geoMap.readFile("../cntry08");
	  //geoMap.getAttributes().writeAsTable(5);
	//  geoMap.screenToGeo(width - 500, height - 100);
	}

	public void draw()
	{
		 background(180, 210, 240);
		  stroke(0);
		  fill(150, 190, 150);
		  geoMap.draw();

		  int id = geoMap.getID(mouseX, mouseY);
		  if (id != -1)
		  {
		    fill(180, 120, 120);
		    geoMap.draw(id);
		  }

		  noStroke();
		  fill(255, 192);
		  rect(0, 0, width, 20);

		  if (id != -1)
		  {
		    String name = geoMap.getAttributes().getString(id, 6);
		    fill(0);
		    textAlign(LEFT, CENTER);
		    text(name, 0, 0, width, 20);
		  }

	}

}
