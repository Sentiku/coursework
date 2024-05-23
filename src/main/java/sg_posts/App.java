package sg_posts;

import org.example.Post;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class App {
    public static void main(String[] args) throws IOException, NullPointerException {
        List<Post> posts = new ArrayList<>();
        System.out.println("Подключение к главной странице...");
        Document doc = Jsoup.connect("https://stopgame.ru/").get();
            Elements postTitleElements = doc.getElementsByAttributeValue("class", "_news-widget__item_1f4k2_292");
            for (Element postTitleElement : postTitleElements) {
                String detailsLink = "https://stopgame.ru/" + postTitleElement.attr("href");
                Post post = new Post();
                post.setDetailsLink(detailsLink);
                post.setTitle(postTitleElement.attr("aria-label"));
                System.out.println("Подключение к деталям поста " + "https://stopgame.ru/" + detailsLink);
                Document postDetailsDoc = Jsoup.connect(detailsLink).get();
                try {
                    Element authorDetails = postDetailsDoc.getElementsByClass("_user-info_1jnog_1133 _user-info--in-team_1jnog_1 _author_12po9_1532").first();
                    post.setAuthor(authorDetails.text());
                    post.setAuthorDetailsLink(authorDetails.attr("href"));
                    post.setDateOfCreated(postDetailsDoc.getElementsByClass("_date_12po9_591 _date--full_12po9_1").first().text());
                } catch (NullPointerException e) {
                    post.setAuthor("Нет автора");
                    post.setAuthorDetailsLink("Нет ссылки на автора");
                    post.setDateOfCreated("Нет даты создания");
                }
                posts.add(post);
            }
            posts.forEach(System.out::println);
        }
    }
//postTitleElements.forEach(postTitleElement -> System.out.println("https://stopgame.ru/" + postTitleElements.attr("href") + " | " + postTitleElement.attr("aria-label")));