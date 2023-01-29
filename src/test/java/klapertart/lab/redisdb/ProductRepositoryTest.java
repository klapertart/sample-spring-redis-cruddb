package klapertart.lab.redisdb;

import klapertart.lab.redisdb.entity.Product;
import klapertart.lab.redisdb.repository.ProductRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

/**
 * @author kurakuraninja
 * @since 29/01/23
 */

@SpringBootTest
public class ProductRepositoryTest {

    @Autowired
    private ProductRepository repository;

    @Test
    void save() {
        Product product = Product.builder()
                .id(1)
                .name("Indomie")
                .price(3000L)
                .qty(1)
                .build();


        Product result = repository.save(product);

        Assertions.assertNotNull(result);
        Assertions.assertEquals(1,result.getId());
        Assertions.assertEquals("Indomie",result.getName());
    }

    @Test
    void findAll() {
        List<Product> products = repository.findAll();

        Assertions.assertNotNull(products);
        Assertions.assertEquals(1,products.size());
    }

    @Test
    void findById() {
        Product product = repository.findProductById(1);

        Assertions.assertNotNull(product);
        Assertions.assertEquals("Indomie",product.getName());
    }

    @Test
    void delete() {
        Assertions.assertEquals("product removed!",repository.deleteProduct(1));
    }
}
