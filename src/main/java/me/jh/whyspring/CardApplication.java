package me.jh.whyspring;

import me.jh.whyspring.components.CardShop;

public class CardApplication {
    
    private static CardShop shop;
    
    public CardApplication() {
        shop = null; // replace this
    }
    
    public static void main(String... args) {
        
        String type = args[0];
        String name = args[1];
        
        CardApplication app = new CardApplication();
        app.run(type,name);
    }
    
    private void run(String type, String name) {
        System.out.println(shop.buy(type, name));
    }

}
