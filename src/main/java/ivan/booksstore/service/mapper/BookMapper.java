package ivan.booksstore.service.mapper;

import ivan.booksstore.config.MapperConfig;
import ivan.booksstore.dto.BookDto;
import ivan.booksstore.dto.CreateBookRequestDto;
import ivan.booksstore.model.Book;
import org.mapstruct.Mapper;

@Mapper(config = MapperConfig.class)
public interface BookMapper {
    BookDto toDto(Book book);

    Book toModel(CreateBookRequestDto dto);
}
