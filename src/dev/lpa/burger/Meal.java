package dev.lpa.burger;

// Three kinds of item: Burger, Drink, Side

import java.util.ArrayList;
import java.util.List;

public class Meal {

//    base price
    private double price = 5.0;
    private Burger burger;
    private Item drink;
    private Item side;
    private double conversionRate;


    public void addBurgerToppings(Burger burger, String... toppings){
        List<String> toppingsList = new ArrayList<>(List.of(toppings));

        for (String topping : toppings){
            double priceIncrease = switch(topping){
                case "bacon" -> 0.50;
                case "mozzarella" -> 0.75;
                case "Chick Fil A Sauce" ->0.4;
                default -> 0;
            };
//            burger.toppings.add(new Item(""));
            // TODO: Increase price
        }
    }


    public Meal() {
        // No conversion rate
        this(1);
    }

    public Meal(double conversionRate) {
        this.conversionRate = conversionRate;
        burger = new Burger("regular");
        drink = new Item("coke", "drink", 1.5);
        System.out.println(drink.name);
        side = new Item("fries", "side", 2.0);
    }

    private double getTotal(){
        double total = burger.getPrice() + drink.price + side.price;
        return Item.getPrice(total, conversionRate);
    }

    @Override
    public String toString() {
        return "%s%n%s%n%s%n%26s$%.2f".formatted(burger, drink, side, "Total Due: ", getTotal());
    }

    //CHALLENGE:
//Make another inner class: Burger
    // Specialized Item. List of toppings: Also Items
    // Items have name , type, price and method to convert prices
    // User can add toppings using Meal class, which it then delegates to burger class
    // Allow toppings to be added with a mtd that allows variable number of Strings, representing the toppings selected
    // Toppings are priced differently; some free; some have additional cost
    // Print toppings with burger info

    private class Burger extends Item{

        public double getPrice(){
            return super.price;
        }

        private List<Item> toppings = new ArrayList<>();

        // Not declaring this public; access is as restrictive as we can make it.
        Burger(String name) {
            super(name, "burger", 5.0);
        }
    }

    private class Item{
        private String name;
        private String type;
        private double price;

        public Item(String name, String type) {
            // Calls the three args constructor
            this(name, type, type.equals("burger") ? Meal.this.price : 0);
        }

        public Item(String name, String type, double price) {
            this.name = name;
            this.type = type;
            this.price = price;
        }

        @Override
        public String toString() {
            return "%10s%15s $%.2f".formatted(type, name, getPrice(price, conversionRate));
        }

        // Intended for conversion AUD-USD
        private static double getPrice (double price, double rate){
            return price * rate;
        }

    }

}




