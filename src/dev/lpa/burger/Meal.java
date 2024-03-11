package dev.lpa.burger;

// Three kinds of item: Burger, Drink, Side

public class Meal {

    private class Item{
        private String name;
        private String type;
        private double price;

        public Item(String name, String type) {
            // Calls the three args constructor
            this(name, type, 0);
        }

        public Item(String name, String type, double price) {
            this.name = name;
            this.type = type;
            this.price = price;
        }

        @Override
        public String toString() {
            return "%10s%15s $%.2f".formatted(type, name, price)
        }
    }



}
