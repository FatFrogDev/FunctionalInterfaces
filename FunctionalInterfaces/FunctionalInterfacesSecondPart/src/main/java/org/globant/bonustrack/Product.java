package org.globant.bonustrack;

import java.text.DecimalFormat;
import java.time.LocalDate;
import java.util.List;

enum Color{
    RED, BLUE, BLACK, WHITE, YELLOW, GREEN, MAROON, PURPLE
}

class Person {
    String document;
    String name;
    String address;
    LocalDate birthDay;

}

public class Product{
    String code;
    String description;
    Color color;
    Double price;

    public Product(String code, String description, Color color, Double price) {
        this.code = code;
        this.description = description;
        this.color = color;
        this.price = price;
    }




    @Override
    public String toString() {
        DecimalFormat decimalFormat = new DecimalFormat("#.00");
        return "Product{" +
                "code='" + code + '\'' +
                ", description='" + description + '\'' +
                ", color=" + color +
                ", price=" + decimalFormat.format(price) +
                '}';
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }
}

