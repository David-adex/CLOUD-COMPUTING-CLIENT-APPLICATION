/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package getWeather;

/**
 *
 * @author david
 */
public class Station {
    private double distance;
    private double latitude;
    private double longitude;
    private long useCount;
    private String id;
    private String name;
    private long quality;
    private double contribution;

    public double getDistance() { return distance; }
    public void setDistance(double value) { this.distance = value; }

    public double getLatitude() { return latitude; }
    public void setLatitude(double value) { this.latitude = value; }

    public double getLongitude() { return longitude; }
    public void setLongitude(double value) { this.longitude = value; }

    public long getUseCount() { return useCount; }
    public void setUseCount(long value) { this.useCount = value; }

    public String getID() { return id; }
    public void setID(String value) { this.id = value; }

    public String getName() { return name; }
    public void setName(String value) { this.name = value; }

    public long getQuality() { return quality; }
    public void setQuality(long value) { this.quality = value; }

    public double getContribution() { return contribution; }
    public void setContribution(double value) { this.contribution = value; }
}

