package com.streamapi;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class FilterDemo {
    public static void main(String[] args) {
        List<Product> list = new ArrayList<>();
        for(Product product : getProducts()){
            if(product.getPrice() > 25000f)
                list.add(product);
        }
        for(Product product : list){
            System.out.println(product);
        }

        //using stream api
       List<Product> list1 = getProducts().stream().filter((product) -> product.getPrice() > 25000f).toList();
        list1.forEach(System.out::println);
    }
    private static List<Product> getProducts(){
        List<Product> productList = new ArrayList<>();
        productList.add(new Product(1, "DELL", 25000f));
        productList.add(new Product(2, "HP", 28000f));
        productList.add(new Product(3, "MAC", 250000f));
        productList.add(new Product(4, "LENOVO", 27000f));
        return productList;
    }
}
class Product{
    private int id;
    private String name;
    private float price;

    public Product(int id, String name, float price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }
    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", price=" + price +
                '}';
    }

}