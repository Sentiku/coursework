package org.example;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class App {
    public static void main(String[] args) throws IOException, NullPointerException{
        List<Quote> quotes = new ArrayList<>();
        System.out.println("Получение актуальных данных о валютах...");
        Document doc = Jsoup.connect("https://www.banki.ru/products/currency/cb/").get();
        Elements currencyTerms = doc.getElementsByAttributeValue("class", "FlexboxGrid__sc-akw86o-0 ybYcl");
        for (Element currecyTerm : currencyTerms) {
            Quote quote = new Quote();
            try {
                quote.setName(currecyTerm.getElementsByClass("Text__sc-j452t5-0 fOLdnH currencyCbListItemstyled__StyledName-sc-12ajhcx-4 nLxpH").first().text());
                quote.setCost(currecyTerm.getElementsByClass("Text__sc-j452t5-0 jxxlPG").first().text());
                Element exchangeDetails = currecyTerm.getElementsByClass("Button__sc-16w8pak-2 dgmPSL").first();
                quote.setExchange("https://www.banki.ru/" + exchangeDetails.attr("href"));
            } catch (NullPointerException e){
                quote.setName("Название не найдено");
                quote.setCost("Цена не найдена");
            }


            quotes.add(quote);
        }

        quotes.forEach(System.out::println);
    }
}