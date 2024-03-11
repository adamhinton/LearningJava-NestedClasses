package dev.lpa.burger;

// Three kinds of item: Burger, Drink, Side

public class Meal {

//    base price
    private double price = 5.0;
    private Item burger;
    private Item drink;
    private Item side;
    private double conversionRate;


    public Meal(double conversionRate) {
        this.conversionRate = conversionRate;
        burger = new Item("regular", "burger");
        drink = new Item("coke", "drink", 1.5);
        System.out.println(drink.name);
        side = new Item("fries", "side", 2.0);
    }

    @Override
    public String toString() {
        return "%s%n%s%n%s%n".formatted(burger, drink, side);
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
            return "%10s%15s $%.2f".formatted(type, name, price);
        }

        // Intended for conversion AUD-USD
        private static double getPrice (double price, double rate){
            return price * rate;
        }

    }



}
