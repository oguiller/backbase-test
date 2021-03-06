package com.backbase.entity;

import javax.persistence.Embeddable;

@Embeddable
public class GeoLocation {

    private float lat;

    private float lng;

    public float getLat() {
        return lat;
    }

    public void setLat(float lat) {
        this.lat = lat;
    }

    public float getLng() {
        return lng;
    }

    public void setLng(float lng) {
        this.lng = lng;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        GeoLocation that = (GeoLocation) o;

        if (lat != that.lat) return false;
        return lng == that.lng;
    }


    @Override
    public int hashCode() {
        int result = (lat != +0.0f ? Float.floatToIntBits(lat) : 0);
        result = 31 * result + (lng != +0.0f ? Float.floatToIntBits(lng) : 0);
        return result;
    }

    @Override
    public String toString() {
        return "GeoLocation{" +
                "lat=" + lat +
                ", lng=" + lng +
                '}';
    }
}
