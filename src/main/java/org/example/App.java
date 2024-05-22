package org.example;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class App {
    public static void main(String[] args) throws IOException {
        List<Quote> quotes = new ArrayList<>();
        Document doc = Jsoup.connect("https://www.banki.ru/products/currency/cb/").get();
        Elements tableOFCourses = doc.getElementsByAttributeValue("class", "GridCol__sc-n5ivvz-0 jnxKZK");
        for (Element tableOFCourse : tableOFCourses) {
            Quote quote = new Quote();
            String name = tableOFCourse.select(".Text__sc-j452t5-0 fOLdnH currencyCbListItemstyled__StyledName-sc-12ajhcx-4 nLxpH").first.text();
            String cost = tableOFCourse.select(".Text__sc-j452t5-0 jxxlPG").first.text();
            String exchange = tableOFCourse.select(".currencyCbListItemstyled__StyledButtonWrapper-sc-12ajhcx-5 iJlOJT").first.text();
            quote.setName(name);
            quote.setCost(cost);
            quote.setExchange(exchange);
            quotes.add(quote);
        }


        quotes.forEach(System.out::println);
    }
}