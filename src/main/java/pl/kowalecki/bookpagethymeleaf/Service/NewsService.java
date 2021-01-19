package pl.kowalecki.bookpagethymeleaf.Service;

import pl.kowalecki.bookpagethymeleaf.Model.News;

import java.util.List;

public interface NewsService {
    String getTitle();
    String getText();
    String getImage();
    List<News> getallNews();
}
