package ivan.booksstore.dto;

import java.math.BigDecimal;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class CreateBookRequestDto {
    private Long id;
    @NotNull
    @Size(min = 5, max = 30)
    private String title;
    @NotNull
    @Size(min = 5, max = 30)
    private String author;
    @NotNull
    @Size(min = 10, max = 16)
    private String isbn;
    @NotNull
    @DecimalMin(value = "1.0")
    private BigDecimal price;
    private String description;
    private String coverImage;
}
