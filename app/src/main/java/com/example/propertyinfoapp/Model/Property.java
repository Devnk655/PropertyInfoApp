package com.example.propertyinfoapp.Model;

public class Property {
    private int propertyId;
    private String name;
    private Double price;
    private String area;
    private String seventwelvedocument;

    public Property(int propertyId, String name, Double price, String area, String seventwelvedocument) {
       setPropertyId(propertyId);
       setName(name);
       setPrice(price);
       setArea(area);
       setSeventwelvedocument(seventwelvedocument);
    }

    public int getPropertyId() {
        return propertyId;
    }

    public void setPropertyId(int propertyId) {
        this.propertyId = propertyId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public String getSeventwelvedocument() {
        return seventwelvedocument;
    }

    public void setSeventwelvedocument(String seventwelvedocument) {
        this.seventwelvedocument = seventwelvedocument;
    }
}
