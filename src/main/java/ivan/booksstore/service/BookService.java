package ivan.booksstore.service;

import ivan.booksstore.dto.BookDto;
import ivan.booksstore.dto.BookSearchParameters;
import ivan.booksstore.dto.CreateBookRequestDto;
import org.springframework.data.domain.Pageable;
import java.util.List;

public interface BookService {
    BookDto save(CreateBookRequestDto book);

    List<BookDto> findAll(Pageable pageable);

    BookDto getBookById(Long id);

    BookDto update(Long id, CreateBookRequestDto update);

    List<BookDto> search(BookSearchParameters searchParameters);

    void deleteById(Long id);
}
