/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package getWeather;

/**
 *
 * @author david
 */
import java.time.LocalDate;
import java.time.OffsetTime;

public class Day {
    private LocalDate datetime;
    private long datetimeEpoch;
    private double tempmax;
    private double tempmin;
    private double temp;
    private double feelslikemax;
    private double feelslikemin;
    private double feelslike;
    private double dew;
    private double humidity;
    private double precip;
    private double precipprob;
    private double precipcover;
    private String[] preciptype;
    private double snow;
    private double snowdepth;
    private double windgust;
    private double windspeed;
    private double winddir;
    private double pressure;
    private double cloudcover;
    private double visibility;
    private double solarradiation;
    private double solarenergy;
    private double uvindex;
    private double severerisk;
    private OffsetTime sunrise;
    private long sunriseEpoch;
    private OffsetTime sunset;
    private long sunsetEpoch;
    private double moonphase;
    private String conditions;
    private String description;
    private String icon;
    private String[] stations;
    private String source;

    public LocalDate getDatetime() { return datetime; }
    public void setDatetime(LocalDate value) { this.datetime = value; }

    public long getDatetimeEpoch() { return datetimeEpoch; }
    public void setDatetimeEpoch(long value) { this.datetimeEpoch = value; }

    public double getTempmax() { return tempmax; }
    public void setTempmax(double value) { this.tempmax = value; }

    public double getTempmin() { return tempmin; }
    public void setTempmin(double value) { this.tempmin = value; }

    public double getTemp() { return temp; }
    public void setTemp(double value) { this.temp = value; }

    public double getFeelslikemax() { return feelslikemax; }
    public void setFeelslikemax(double value) { this.feelslikemax = value; }

    public double getFeelslikemin() { return feelslikemin; }
    public void setFeelslikemin(double value) { this.feelslikemin = value; }

    public double getFeelslike() { return feelslike; }
    public void setFeelslike(double value) { this.feelslike = value; }

    public double getDew() { return dew; }
    public void setDew(double value) { this.dew = value; }

    public double getHumidity() { return humidity; }
    public void setHumidity(double value) { this.humidity = value; }

    public double getPrecip() { return precip; }
    public void setPrecip(double value) { this.precip = value; }

    public double getPrecipprob() { return precipprob; }
    public void setPrecipprob(double value) { this.precipprob = value; }

    public double getPrecipcover() { return precipcover; }
    public void setPrecipcover(double value) { this.precipcover = value; }

    public String[] getPreciptype() { return preciptype; }
    public void setPreciptype(String[] value) { this.preciptype = value; }

    public double getSnow() { return snow; }
    public void setSnow(double value) { this.snow = value; }

    public double getSnowdepth() { return snowdepth; }
    public void setSnowdepth(double value) { this.snowdepth = value; }

    public double getWindgust() { return windgust; }
    public void setWindgust(double value) { this.windgust = value; }

    public double getWindspeed() { return windspeed; }
    public void setWindspeed(double value) { this.windspeed = value; }

    public double getWinddir() { return winddir; }
    public void setWinddir(double value) { this.winddir = value; }

    public double getPressure() { return pressure; }
    public void setPressure(double value) { this.pressure = value; }

    public double getCloudcover() { return cloudcover; }
    public void setCloudcover(double value) { this.cloudcover = value; }

    public double getVisibility() { return visibility; }
    public void setVisibility(double value) { this.visibility = value; }

    public double getSolarradiation() { return solarradiation; }
    public void setSolarradiation(double value) { this.solarradiation = value; }

    public double getSolarenergy() { return solarenergy; }
    public void setSolarenergy(double value) { this.solarenergy = value; }

    public double getUvindex() { return uvindex; }
    public void setUvindex(double value) { this.uvindex = value; }

    public double getSevererisk() { return severerisk; }
    public void setSevererisk(double value) { this.severerisk = value; }

    public OffsetTime getSunrise() { return sunrise; }
    public void setSunrise(OffsetTime value) { this.sunrise = value; }

    public long getSunriseEpoch() { return sunriseEpoch; }
    public void setSunriseEpoch(long value) { this.sunriseEpoch = value; }

    public OffsetTime getSunset() { return sunset; }
    public void setSunset(OffsetTime value) { this.sunset = value; }

    public long getSunsetEpoch() { return sunsetEpoch; }
    public void setSunsetEpoch(long value) { this.sunsetEpoch = value; }

    public double getMoonphase() { return moonphase; }
    public void setMoonphase(double value) { this.moonphase = value; }

    public String getConditions() { return conditions; }
    public void setConditions(String value) { this.conditions = value; }

    public String getDescription() { return description; }
    public void setDescription(String value) { this.description = value; }

    public String getIcon() { return icon; }
    public void setIcon(String value) { this.icon = value; }

    public String[] getStations() { return stations; }
    public void setStations(String[] value) { this.stations = value; }

    public String getSource() { return source; }
    public void setSource(String value) { this.source = value; }
}
