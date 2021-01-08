package pl.kowalecki.bookpagethymeleaf.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import pl.kowalecki.bookpagethymeleaf.BookRepo;
import pl.kowalecki.bookpagethymeleaf.Model.Book;
import pl.kowalecki.bookpagethymeleaf.Service.BookService;

@Controller
public class BookController {

    BookRepo bookRepo;
    BookService bookService;

    @Autowired
    public BookController(BookService bookService, BookRepo bookRepo) {
        this.bookService = bookService;
        this.bookRepo = bookRepo;
    }


    @GetMapping("")
    public String showBooks(Model model){
        model.addAttribute("book", bookService.getAllBooks());
        return "index";

    }

    @GetMapping("/dodaj")
    public String addBooksForm(Book book){
        return "add-book";
    }

    @PostMapping("/addbook")
    public String addBook(@Validated Book book, BindingResult result, Model model){
        if (result.hasErrors()){
            return "add-books";
        }
        bookService.addBook(book);
        return "redirect:/index";
    }


}
