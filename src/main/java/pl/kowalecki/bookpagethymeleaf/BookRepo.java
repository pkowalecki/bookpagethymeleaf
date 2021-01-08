package pl.kowalecki.bookpagethymeleaf;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.kowalecki.bookpagethymeleaf.Model.Book;

@Repository
public interface BookRepo extends JpaRepository<Book, Long> {
}
