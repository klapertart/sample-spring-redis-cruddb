package klapertart.lab.redisdb.repository;

import klapertart.lab.redisdb.entity.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author kurakuraninja
 * @since 29/01/23
 */

@Repository
public class ProductRepository {

    @Autowired
    public RedisTemplate template;

    private static final String HASH_KEY = "Product";

    public Product save(Product product){
        template.opsForHash().put(HASH_KEY,product.getId(),product);
        return product;
    }

    public List<Product> findAll(){
        return template.opsForHash().values(HASH_KEY);
    }

    public Product findProductById(int id){
        return (Product) template.opsForHash().get(HASH_KEY, id);
    }

    public String deleteProduct(int id){
        template.opsForHash().delete(HASH_KEY,id);
        return "product removed!";
    }
}
