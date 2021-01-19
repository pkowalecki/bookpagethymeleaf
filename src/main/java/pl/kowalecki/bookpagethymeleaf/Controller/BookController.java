package pl.kowalecki.bookpagethymeleaf.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import pl.kowalecki.bookpagethymeleaf.Repository.BookRepo;
import pl.kowalecki.bookpagethymeleaf.Model.Book;
import pl.kowalecki.bookpagethymeleaf.Service.BookService;
import pl.kowalecki.bookpagethymeleaf.Service.NewsService;

import java.util.Optional;

@Controller
public class BookController {

    BookRepo bookRepo;
    BookService bookService;
    NewsService newsService;

    @Autowired
    public BookController(BookService bookService, BookRepo bookRepo, NewsService newsService) {
        this.bookService = bookService;
        this.bookRepo = bookRepo;
        this.newsService = newsService;

    }

    @GetMapping("")
    public String showBooks(Model model){
        model.addAttribute("book", bookService.getAllBooks());
        model.addAttribute("news", newsService.getText());
        return "index";

    }

    @GetMapping("/dodaj")
    public String addBooksForm(Model model, Book book)
    {
        model.addAttribute("newsImage", newsService.getImage());
        return "add-book";
    }

    @PostMapping("/addbook")
    public String addBook(@Validated Book book, BindingResult result, Model model){
        if (result.hasErrors()){
            return "add-books";
        }
        bookService.addBook(book);
        return "redirect:/";
    }

    @GetMapping("/edytujKsiazke/{id}")
    public String editBookForm(@PathVariable(value="id") Long boo_id, Model model){
        Optional<Book> book = bookRepo.findById(boo_id);
        model.addAttribute("book", book);
        model.addAttribute("newsImage", newsService.getImage());
        return "edit-book";
    }

    @PostMapping("/editBook/{id}")
    public String editBook(@PathVariable(value="id") Long boo_id, @Validated Book book, BindingResult result, Model model){
        if (result.hasErrors()){
            return "edit-book";
        }else{
            bookRepo.save(book);
            return "redirect:/";
        }
    }

}
