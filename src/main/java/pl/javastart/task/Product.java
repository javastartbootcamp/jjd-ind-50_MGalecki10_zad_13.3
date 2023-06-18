package pl.javastart.task;

import java.math.BigDecimal;

public class Product {
    private String name;
    private BigDecimal price;
    private String currencyCode;

    public Product(String name, BigDecimal price, String currencyCode) {
        this.name = name;
        this.price = price;
        this.currencyCode = currencyCode;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public String getCurrencyCode() {
        return currencyCode;
    }

    public void setCurrencyCode(String currencyCode) {
        this.currencyCode = currencyCode;
    }

    @Override
    public String toString() {
        return name + " " + price + " " + currencyCode;
    }
}
