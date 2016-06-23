package me.jh.whyspring.components.impl;

import me.jh.whyspring.components.CardMaker;
import me.jh.whyspring.components.GreetingService;

public class AsciiArtCardMaker implements CardMaker {

    private String picture;
    private GreetingService greeter;
    
    @Override
    public String create(String name) {
        return picture + "\n\n" + greeter.greeting(name);
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }

    public void setGreeter(GreetingService greeter) {
        this.greeter = greeter;
    }

}
