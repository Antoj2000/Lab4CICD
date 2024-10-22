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
        //Send it to do business logic
        ProductService myService = new ProductService();
        list = myService.addProduct(product);
        return list;
    }

    @GetMapping
    public List<Product> getAllProducts(){
        return list;
    }

    @PutMapping("/{id}")
    List<Product> updateProduct(@PathVariable String id , @RequestBody Product updatedProduct){
        ProductService myService = new ProductService();
        list = myService.updateProduct(id, updatedProduct);
        return list;

    }

}
