package ie.atu.lab4;


import lombok.Data;
import lombok.NoArgsConstructor;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import org.springframework.validation.annotation.Validated;


@Data
@NoArgsConstructor
public class Product {

    @NotBlank(message = "Employee ID invalid")
    @Size(max = 7, message = "ID cannot be more than 7 characters")
    private String id;

    @NotBlank(message = "Name cannot be blank")
    private String name;



    private double price;
}
