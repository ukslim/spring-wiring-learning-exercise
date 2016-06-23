package me.jh.whyspring.components.impl;

import me.jh.whyspring.components.GreetingService;

public class PrefixGreetingService implements GreetingService {

    private String prefix;

    @Override
    public String greeting(String name) {
        return prefix + " " + name;
    }

    public void setPrefix(String prefix) {
        this.prefix = prefix;
    }
}
