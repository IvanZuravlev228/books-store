package ivan.booksstore.service.impl;

import ivan.booksstore.dto.BookDto;
import ivan.booksstore.dto.CreateBookRequestDto;
import ivan.booksstore.exception.EntityNotFoundException;
import ivan.booksstore.repository.BookRepository;
import ivan.booksstore.service.BookService;
import ivan.booksstore.service.mapper.BookMapper;
import java.util.List;
import java.util.stream.Collectors;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class BookServiceImpl implements BookService {
    private final BookRepository bookRepository;
    private final BookMapper bookMapper;

    @Override
    public BookDto save(CreateBookRequestDto book) {
        return bookMapper.toDto(bookRepository.save(bookMapper.toModel(book)));
    }

    @Override
    public List<BookDto> findAll() {
        return bookRepository.findAll()
                .stream()
                .map(bookMapper::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public BookDto getBookById(Long id) {
        return bookMapper.toDto(bookRepository.findById(id).orElseThrow(
                () -> new EntityNotFoundException("Can't find a book with id: " + id)));
    }
}
