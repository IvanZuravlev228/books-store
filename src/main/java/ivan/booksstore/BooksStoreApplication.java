package ivan.booksstore;

import ivan.booksstore.model.Book;
import ivan.booksstore.service.BookService;
import java.math.BigDecimal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class BooksStoreApplication {
    @Autowired
    private BookService bookService;

    public static void main(String[] args) {
        SpringApplication.run(BooksStoreApplication.class, args);
    }

    @Bean
    public CommandLineRunner commandLineRunner() {
        return args -> {
            Book book = new Book();
            book.setTitle("Book Title");
            book.setAuthor("Ivan Zhuravlev");
            book.setIsbn("978-0-9767736-6-5");
            book.setPrice(BigDecimal.valueOf(100.500));
            book.setDescription("Best of the best books");
            book.setCoverImage("image");
            bookService.save(book);

            System.out.println(book);
        };
    }
}
