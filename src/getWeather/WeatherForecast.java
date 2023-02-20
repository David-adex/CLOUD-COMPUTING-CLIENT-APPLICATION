/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package getWeather;

/**
 *
 * @author david
 */
import java.util.Map;

public class WeatherForecast {
    private long queryCost;
    private double latitude;
    private double longitude;
    private String resolvedAddress;
    private String address;
    private String timezone;
    private double tzoffset;
    private Day[] days;
    private Map<String, Station> stations;

    public long getQueryCost() { return queryCost; }
    public void setQueryCost(long value) { this.queryCost = value; }

    public double getLatitude() { return latitude; }
    public void setLatitude(double value) { this.latitude = value; }

    public double getLongitude() { return longitude; }
    public void setLongitude(double value) { this.longitude = value; }

    public String getResolvedAddress() { return resolvedAddress; }
    public void setResolvedAddress(String value) { this.resolvedAddress = value; }

    public String getAddress() { return address; }
    public void setAddress(String value) { this.address = value; }

    public String getTimezone() { return timezone; }
    public void setTimezone(String value) { this.timezone = value; }

    public double getTzoffset() { return tzoffset; }
    public void setTzoffset(double value) { this.tzoffset = value; }

    public Day[] getDays() { return days; }
    public void setDays(Day[] value) { this.days = value; }

    public Map<String, Station> getStations() { return stations; }
    public void setStations(Map<String, Station> value) { this.stations = value; }
}
