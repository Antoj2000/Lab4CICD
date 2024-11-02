package ie.atu.lab4;



import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.validation.annotation.Validated;


@Data
@NoArgsConstructor
public class Product {

    @NotBlank(message = "Employee ID invalid")
    @Size(max = 7, message = "ID cannot be more than 7 characters")
    private String id;

    @NotBlank(message = "Name cannot be blank")
    private String name;


    @Positive(message = "Price must be a positive number")
    private double price;
}
