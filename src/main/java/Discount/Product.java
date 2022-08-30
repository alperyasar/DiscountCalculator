package Discount;

/**
 * Each prodcuct has type name and price
 * type eg. phone, tv, shirt...
 */
public class Product {
    public String type;
    private int price;

    public Product(String type){
        this.type= type;
    }
    public Product(String type, int price){
        this.type= type;
        this.price = price;
    }

    public int getPrice() {
        return price;
    }
}
