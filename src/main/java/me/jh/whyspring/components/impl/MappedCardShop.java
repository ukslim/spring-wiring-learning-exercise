package me.jh.whyspring.components.impl;

import java.util.Map;
import me.jh.whyspring.components.CardMaker;
import me.jh.whyspring.components.CardShop;

public class MappedCardShop implements CardShop {

    private Map<String,CardMaker> makerMap;
    
    @Override
    public String buy(String type, String name) {
        CardMaker maker = makerMap.get(type);
        return maker.create(name);
    }

    public void setMakerMap(Map<String, CardMaker> makerMap) {
        this.makerMap = makerMap;
    }

}
