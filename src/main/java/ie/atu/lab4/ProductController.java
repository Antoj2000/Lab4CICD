package ie.atu.lab4;

import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/products")
@Validated
public class ProductController {

    private ProductService myService;

    public ProductController(ProductService myService) {

        this.myService = myService;
    }

    private List<Product> list = new ArrayList<>();
    //Creating a class which is interested in request and responses. Separation of concern

    @PostMapping
    public ResponseEntity<?> newProduct(@RequestBody @Valid Product product, BindingResult result)
    {
        // Check if there are validation errors
        if (result.hasErrors()) {
            // Return the validation errors as a response
            return ResponseEntity.badRequest().body(result.getAllErrors());
        }

        // Proceed if validation passes
        return ResponseEntity.ok(myService.addProduct(product));

        //return myService.addProduct(product);
    }

    @GetMapping
    public List<Product> getAllProducts(){

        return myService.getAllProducts();
    }

    @PutMapping("/{id}")
    List<Product> updateProduct(@PathVariable String id , @RequestBody @Valid Product updatedProduct){

        return myService.updateProduct(id, updatedProduct);
    }

    @DeleteMapping("/{id}")
    List<Product> deleteProduct(@PathVariable String id ){

        return myService.deleteProduct(id);
    }


}
