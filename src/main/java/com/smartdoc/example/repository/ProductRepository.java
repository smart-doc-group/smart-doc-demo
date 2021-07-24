package com.smartdoc.example.repository;

import com.smartdoc.example.model.Product;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.Collectors;

/**
 * @author yu 2021/7/24.
 */
public class ProductRepository {

    private Map<Long, Product> products = new ConcurrentHashMap<>();

    public Optional<Product> findById(long id) {
        return Optional.ofNullable(products.get(id));
    }

    public void add(Product book) {
        products.put(book.getId(), book);
    }

    public List<Product> getProducts() {
        return products.values().stream().collect(Collectors.toList());
    }

    public boolean delete(Product Product) {
        return products.remove(Product.getId(),Product);
    }
}
