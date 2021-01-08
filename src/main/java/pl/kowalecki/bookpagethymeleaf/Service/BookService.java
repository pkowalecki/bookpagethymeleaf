package pl.kowalecki.bookpagethymeleaf.Service;

import pl.kowalecki.bookpagethymeleaf.Model.Book;

import java.util.List;

public interface BookService {
    List<Book> getAllBooks();
    boolean addBook(Book book);
}
