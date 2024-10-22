package ie.atu.lab4;

import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {

    private ProductService myService;

    public ProductController(ProductService myService) {
        this.myService = myService;
    }

    private List<Product> list = new ArrayList<>();
    //Creating a class which is interested in request and responses. Separation of concern

    @PostMapping
    public List<Product> newProduct(@RequestBody Product product)
    {
        return myService.addProduct(product);
    }

    @GetMapping
    public List<Product> getAllProducts(){

        return myService.getAllProducts();
    }

    @PutMapping("/{id}")
    List<Product> updateProduct(@PathVariable String id , @RequestBody Product updatedProduct){

        return myService.updateProduct(id, updatedProduct);

    }

    @DeleteMapping("/{id}")
    List<Product> deleteProduct(@PathVariable String id ){

        return myService.deleteProduct(id);
    }


}
