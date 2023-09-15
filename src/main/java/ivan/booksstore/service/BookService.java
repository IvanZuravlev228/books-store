package ivan.booksstore.service;

import java.util.List;
import ivan.booksstore.model.Book;

public interface BookService {
    Book save(Book book);

    List<Book> findAll();
}