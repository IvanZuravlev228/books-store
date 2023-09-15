package ivan.booksstore.service;

import ivan.booksstore.model.Book;
import java.util.List;

public interface BookService {
    Book save(Book book);

    List<Book> findAll();
}
