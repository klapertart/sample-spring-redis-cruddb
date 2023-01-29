package klapertart.lab.redisdb.controller;

import klapertart.lab.redisdb.entity.Product;
import klapertart.lab.redisdb.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author kurakuraninja
 * @since 29/01/23
 */

@RestController
@RequestMapping("/api/product")
public class ProductController {

    @Autowired
    private ProductRepository repository;

    @PostMapping
    public Product save(@RequestBody Product product){
        return repository.save(product);
    }

    @GetMapping
    public List<Product> getAllProducts(){
        return repository.findAll();
    }

    @GetMapping("/{id}")
    public Product getProductById(@PathVariable int id){
        return repository.findProductById(id);
    }

    @DeleteMapping("/{id}")
    public String remove(@PathVariable int id){
        return repository.deleteProduct(id);
    }

}
