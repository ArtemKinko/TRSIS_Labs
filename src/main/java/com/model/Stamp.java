package com.model;

import javax.persistence.*;
import java.io.Serial;
import java.io.Serializable;

@Entity
@Table(name = "stamp")
public class Stamp implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;

    public Stamp() {

    }

    public Stamp(int id, String stampName, int stampYear, double price, String image) {
        this.stampId = id;
        this.stampName = stampName;
        this.stampYear = stampYear;
        this.price = price;
        this.image = image;
    }

    public Stamp(String stampName, int stampYear, double price, String image) {
        this.stampName = stampName;
        this.stampYear = stampYear;
        this.price = price;
        this.image = image;
    }

    public int getId() {
        return stampId;
    }

    public String getStampName() {
        return stampName;
    }

    public int getStampYear() {
        return stampYear;
    }

    public double getPrice() {
        return price;
    }

    public String getImage() {
        return image;
    }

    @Id
    @Column(name = "stampId")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int stampId;

    @Column(name = "stampName")
    private String stampName;

    @Column(name = "stampYear")
    private int stampYear;

    @Column(name = "price")
    private double price;

    @Column(name = "image")
    private String image;

    @Override
    public String toString() {
        return "Stamp{" +
                "stampId=" + stampId +
                ", stampName='" + stampName + '\'' +
                ", stampYear=" + stampYear +
                ", price=" + price +
                ", image='" + image + '\'' +
                '}';
    }
}
