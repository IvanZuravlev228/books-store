package ivan.booksstore.repository.book.spec;

import java.math.BigDecimal;
import ivan.booksstore.model.Book;
import ivan.booksstore.repository.SpecificationProvider;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Component;

@Component
public class PriceSpecificationProvider implements SpecificationProvider<Book> {
    private static final int INDEX_MIN_PRICE_VALUE = 0;
    private static final int INDEX_MAX_PRICE_VALUE = 1;
    private static final String PRICE_KEY = "price";

    @Override
    public String getKey() {
        return PRICE_KEY;
    }

    public Specification<Book> getSpecification(String[] params) {
        return new Specification<Book>() {
            @Override
            public Predicate toPredicate(Root<Book> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {
                Predicate minPricePredicate = criteriaBuilder.greaterThanOrEqualTo(root.get(PRICE_KEY),
                        new BigDecimal(params[INDEX_MIN_PRICE_VALUE]));
                Predicate maxPricePredicate = criteriaBuilder.lessThanOrEqualTo(root.get(PRICE_KEY),
                        new BigDecimal(params[INDEX_MAX_PRICE_VALUE]));

                return criteriaBuilder.and(minPricePredicate, maxPricePredicate);
            }
        };
    }
}
