package pl.kowalecki.bookpagethymeleaf.Service;

import org.springframework.stereotype.Service;
import pl.kowalecki.bookpagethymeleaf.Controller.NewsController;
import pl.kowalecki.bookpagethymeleaf.Model.News;

import java.util.List;
import java.util.Random;

@Service
public class NewsServiceImpl implements NewsService {
    private Random random;
    private List<News> list;
    private int number;

    private NewsController newsController;

    public NewsServiceImpl(NewsController newsController) {
        this.newsController = newsController;
    }

    public String getTitle() {
        if(number == 0) {rand();}
        String titleRand = list.get(random.nextInt(number)).getTitle();
        return titleRand;
    }
    public String getText() {
        if(number == 0) {rand();}
        String textRand = list.get(random.nextInt(number)).getDescription();
        return textRand;
    }

    public String getImage() {
        if(number == 0) {rand();}
        String imageRand = list.get(random.nextInt(number)).getImage();
        return imageRand;
    }

    @Override
    public List<News> getallNews() {
        return list;
    }

    public void rand(){
        random = new Random();
        list= newsController.getNews().getNews();
        number = list.size();
    }
}

