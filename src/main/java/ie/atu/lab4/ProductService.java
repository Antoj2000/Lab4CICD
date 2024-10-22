package ie.atu.lab4;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.ArrayList;
import java.util.List;
@Service
public class ProductService {

    private  List<Product> myList = new ArrayList<>();

    public List<Product> addProduct( Product product)
    {
        //Do business stuff like retrieving details from db, or generating files pdfs
        myList.add(product);
        return myList;
    }

    public List<Product> getAllProducts() {

        return myList;
    }

    public List<Product> updateProduct(@PathVariable String id, @RequestBody Product updatedProduct) {
        for (Product product : myList) { // runs through each entry into array
            if (product.getId().equals(id)) {   //checks id
                product.setName(updatedProduct.getName());  //updates each detail of product
                product.setPrice(updatedProduct.getPrice());
                break;
            }
        }
     return myList;
    }

    public List<Product> deleteProduct(@PathVariable String id) {
        for (Product product : myList) { // runs through each entry into array
            if (product.getId().equals(id)) {
                myList.remove(product);
                break;
            }
        }
        return myList;
    }



}
