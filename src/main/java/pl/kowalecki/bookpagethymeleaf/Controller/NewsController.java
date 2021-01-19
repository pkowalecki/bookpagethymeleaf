package pl.kowalecki.bookpagethymeleaf.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.client.RestTemplate;
import pl.kowalecki.bookpagethymeleaf.Model.NewsModel;

@Controller
public class NewsController {

    private RestTemplate restTemplate;

    public NewsController() {
        this.restTemplate = new RestTemplate();
    }

    public NewsModel getNews() {
        NewsModel newsModel = restTemplate.getForObject("https://api.currentsapi.services/v1/search?apiKey=kj6pfJKFziOavC8a1jN27ALqOf0Zy_GN9OBv60ZHJ3foYHJb", NewsModel.class);
        return newsModel;
    }
}

