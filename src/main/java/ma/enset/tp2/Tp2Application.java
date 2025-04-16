package ma.enset.tp2;

import ma.enset.tp2.entities.Product;
import ma.enset.tp2.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;

@SpringBootApplication
public class Tp2Application implements ApplicationRunner {

    @Autowired
    private ProductRepository productRepository;
    public static void main(String[] args) {
        SpringApplication.run(Tp2Application.class, args);
    }

    @Override
    public void run(ApplicationArguments args) throws Exception {

        //productRepository.save(new Product("Computer", 4300, 3));
        //productRepository.save(new Product("Printer", 1200, 5));
        //productRepository.save(new Product("Smart Phone", 3200, 23));
        List<Product> products =  productRepository.findAll();
        products.forEach(p -> {
            System.out.println(p.toString());
        });
        Product product = productRepository.findById(Long.valueOf(1)).get();
        System.out.println("*************");
        System.out.println(product.getId());
        System.out.println(product.getName());
        System.out.println(product.getPrice());
        System.out.println(product.getQuantity());
        System.out.println("*************");
        System.out.println("________________________");
        List<Product> productList = productRepository.findByNameContains("C");
        productList.forEach(p -> {
            System.out.println(p);
        });
        System.out.println("________________________");
        List<Product> productList2 = productRepository.findByPriceGreaterThan(3000);
        productList2.forEach(p -> {
            System.out.println(p);
        });
    }
}
