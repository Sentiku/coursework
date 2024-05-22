package org.example;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import java.io.IOException;

public class App 
{
    public static void main( String[] args ) throws IOException {
        Document doc = Jsoup.connect("https://www.banki.ru/products/currency/cb/").get();
        Elements tableOFCourses = doc.getElementsByAttributeValue("class", "GridCol__sc-n5ivvz-0 jnxKZK");

    }
}
