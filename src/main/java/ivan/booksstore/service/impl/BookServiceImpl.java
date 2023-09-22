package ivan.booksstore.service.impl;

import ivan.booksstore.dto.BookDto;
import ivan.booksstore.dto.BookSearchParameters;
import ivan.booksstore.dto.CreateBookRequestDto;
import ivan.booksstore.exception.EntityNotFoundException;
import ivan.booksstore.model.Book;
import ivan.booksstore.repository.SpecificationBuilder;
import ivan.booksstore.repository.book.BookRepository;
import ivan.booksstore.service.BookService;
import ivan.booksstore.service.mapper.BookMapper;

import org.springframework.data.domain.Pageable;
import java.util.List;
import java.util.stream.Collectors;
import lombok.AllArgsConstructor;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class BookServiceImpl implements BookService {
    private final BookRepository bookRepository;
    private final BookMapper bookMapper;
    private final SpecificationBuilder<Book> bookSpecificationBuilder;

    @Override
    public BookDto save(CreateBookRequestDto book) {
        return bookMapper.toDto(bookRepository.save(bookMapper.toModel(book)));
    }

    @Override
    public List<BookDto> findAll(Pageable pageable) {
        return bookRepository.findAll(pageable)
                .stream()
                .map(bookMapper::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public BookDto getBookById(Long id) {
        return bookMapper.toDto(bookRepository.findById(id).orElseThrow(
                () -> new EntityNotFoundException("Can't find a book with id: " + id)));
    }

    @Override
    public BookDto update(Long id, CreateBookRequestDto update) {
        BookDto bookById = getBookById(id);
        update.setId(bookById.getId());
        return bookMapper.toDto(bookRepository.save(bookMapper.toModel(update)));
    }

    @Override
    public List<BookDto> search(BookSearchParameters searchParameters) {
        Specification<Book> bookSpecification = bookSpecificationBuilder.build(searchParameters);
        return bookRepository.findAll(bookSpecification)
                .stream()
                .map(bookMapper::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public void deleteById(Long id) {
        bookRepository.deleteById(id);
    }
}
