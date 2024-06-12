package com.eyram.uno.cards;

import java.util.ArrayList;

public abstract class Card {
    private String name;
    private String color;
    private boolean effect;

    public boolean isEffect() {
        return effect;
    }

    public void setEffect(boolean effect) {
        this.effect = effect;
    }

    public Card(String name, String color, boolean effect) {
        this.name = name;
        this.color = color;
        this.effect = effect;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public abstract ArrayList<Card> request();

    @Override
    public String toString() {
        return "Card " + name + " " + color;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((name == null) ? 0 : name.hashCode());
        result = prime * result + ((color == null) ? 0 : color.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Card other = (Card) obj;
        if (name.equals(other.name) && color.equals(other.color)) {
            return true;
        } else
            return false;
    }

}
