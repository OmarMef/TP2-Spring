package ma.enset.tp2.web;

import ma.enset.tp2.entities.Product;
import ma.enset.tp2.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ProductRestService {
    @Autowired
    private ProductRepository productRepository;

    @GetMapping("/products")
    List<Product> products (){
        return productRepository.findAll();
    }

    @GetMapping("/products/{id}")
    public Product findProductById (@PathVariable Long id){
        return productRepository.findById(id).get();
    }
}
