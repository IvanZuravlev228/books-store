package ivan.booksstore.controller;

import ivan.booksstore.dto.BookDto;
import ivan.booksstore.dto.BookSearchParameters;
import ivan.booksstore.dto.CreateBookRequestDto;
import ivan.booksstore.service.BookService;
import java.util.List;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/books")
public class BookController {
    private final BookService bookService;

    @GetMapping
    public ResponseEntity<List<BookDto>> getAllBooks() {
        return new ResponseEntity<>(bookService.findAll(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<BookDto> getBookById(@PathVariable Long id) {
        return new ResponseEntity<>(bookService.getBookById(id), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<BookDto> saveNewBook(@RequestBody  @Valid CreateBookRequestDto dto) {
        return new ResponseEntity<>(bookService.save(dto), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<BookDto> update(@PathVariable Long id,
                                          @RequestBody @Valid CreateBookRequestDto update) {
        return new ResponseEntity<>(bookService.update(id, update), HttpStatus.OK);
    }

    @GetMapping("/search")
    public ResponseEntity<List<BookDto>> search(BookSearchParameters searchParameters) {
        return new ResponseEntity<>(bookService.search(searchParameters), HttpStatus.OK);
    }
}
