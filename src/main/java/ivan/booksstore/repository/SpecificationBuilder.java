package ivan.booksstore.repository;

import ivan.booksstore.dto.BookSearchParameters;
import org.springframework.data.jpa.domain.Specification;

public interface SpecificationBuilder<T> {
    Specification<T> build (BookSearchParameters searchParameters);
}