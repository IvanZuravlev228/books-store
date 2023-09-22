package ivan.booksstore.repository.book;

import java.util.List;
import ivan.booksstore.model.Book;
import ivan.booksstore.repository.SpecificationProvider;
import ivan.booksstore.repository.SpecificationProviderManager;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class BookSpecificationProviderManager implements SpecificationProviderManager<Book> {
    private final List<SpecificationProvider<Book>> bookSpecificationProviders;

    @Override
    public SpecificationProvider<Book> getSpecificationProvider(String key) {
        return bookSpecificationProviders.stream()
                .filter(p -> p.getKey().equals(key))
                .findFirst()
                .orElseThrow(() -> new RuntimeException("Can't find correct "
                        + "specification provider for key: " + key));
    }
}
