package com.eelok.phoneFactory.DTO;

import java.util.Date;

public class PhoneDTO {
    private long id;
    private String name;
    private int quantity;
    private Date releaseDate;
    private long manufacturerId;

    public PhoneDTO() {
    }

    public PhoneDTO(String name, int quantity, Date releaseDate, long manufacturerId) {
        this.name = name;
        this.quantity = quantity;
        this.releaseDate = releaseDate;
        this.manufacturerId = manufacturerId;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public Date getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(Date releaseDate) {
        this.releaseDate = releaseDate;
    }

    public long getManufacturerId() {
        return manufacturerId;
    }

    public void setManufacturerId(long manufacturerId) {
        this.manufacturerId = manufacturerId;
    }
}
