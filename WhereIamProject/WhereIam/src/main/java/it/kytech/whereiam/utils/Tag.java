package it.kytech.whereiam.utils;

public class Tag implements Comparable<Tag> {
    private String tag;
    private double latitude;
    private double longitude;
    private double altitude;

    public Tag(String tag, Long latitude, Long longitude, Long altitude){
        this.tag = tag;
        this.latitude = latitude;
        this.longitude = longitude;
        this.altitude = altitude;
    }

    public Tag(String tag, Long latitude, Long longitude){
        this(tag, latitude, longitude, (long) 0);
    }

    public Tag(String tag, String latitude, String longitude, String altitude){
        this.tag = tag;
        this.latitude = Double.parseDouble(latitude);
        this.longitude = Double.parseDouble(longitude);
        this.altitude = Double.parseDouble(altitude);
    }

    public Tag(String tag, String latitude, String longitude){
        this(tag, latitude, longitude, "0");
    }


    public String getTag() {
        return tag;
    }

    public double getLongitude() {
        return longitude;
    }

    public double getAltitude() {
        return altitude;
    }

    public double getLatitude() {
        return latitude;
    }

    public void setAltitude(long altitude) {
        this.altitude = altitude;
    }

    public void setLatitude(long latitude) {
        this.latitude = latitude;
    }

    public void setLongitude(long longitude) {
        this.longitude = longitude;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }

    @Override
    public int compareTo(Tag tag) {
        return this.tag.compareTo(tag.getTag());
    }
}
