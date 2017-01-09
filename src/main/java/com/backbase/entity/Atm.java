package com.backbase.entity;


import javax.persistence.*;


@Entity
public class Atm {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;

    @Embedded
    private Address address;

    private long distance;

    private String type;

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public long getDistance() {
        return distance;
    }

    public void setDistance(long distance) {
        this.distance = distance;
    }

    public Long getId() {
        return id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Atm atm = (Atm) o;

        if (distance != atm.distance) return false;
        return address != null ? address.equals(atm.address) : atm.address == null;
    }

    @Override
    public int hashCode() {
        int result = address != null ? address.hashCode() : 0;
        result = 31 * result + (int) (distance ^ (distance >>> 32));
        return result;
    }

    @Override
    public String toString() {
        return "Atm{" +
                "address=" + address +
                ", distance=" + distance +
                '}';
    }
}
