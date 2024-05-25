package org.example;

public class Quote {
    private String name;
    private String cost;
    private String exchange;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCost() {
        return cost;
    }

    public void setCost(String cost) {
        this.cost = cost;
    }

    public String getExchange() {
        return exchange;
    }

    public void setExchange(String exchange) {
        this.exchange = exchange;
    }
    @Override
    public String toString() {
        return "Название валюты: " + name + '\'' +
                ", Стоимость валюты: " + cost + '\'' +
                ", Ссылка на обмен: " + exchange + '\'';
    }
}
