package com.phatbee.cosmeticshopbackend.Service.Impl;

import com.phatbee.cosmeticshopbackend.Entity.Product;
import com.phatbee.cosmeticshopbackend.Repository.ProductRepository;
import com.phatbee.cosmeticshopbackend.Service.ProductService;
import com.phatbee.cosmeticshopbackend.dto.ProductSalesDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductServiceImpl implements ProductService {
    @Autowired
    private ProductRepository productRepository;
    @Override
    public List<Product> getAllProducts() {
        return productRepository.findByActiveTrue();
    }

    @Override
    public List<Product> getProductsByCategory(int categoryID) {
        return productRepository.findByCategoryCategoryId(categoryID);
    }

    @Override
    public List<Product> getRecentProducts() {
        LocalDate today = LocalDate.now();
        today = today.minusDays(7);
        return productRepository.findRecentProducts(today)
                .stream()
                .limit(10)
                .toList();
    }

    @Override
    public List<ProductSalesDTO> getTopSellingProducts() {
        List<Object[]> results = productRepository.findTopSellingProducts();
        return results.stream()
                .map(result -> new ProductSalesDTO((Product) result[0], (Long) result[1]))
                .limit(10)
                .collect(Collectors.toList());
    }

    @Override
    public Product findById(int productId) {
        return productRepository.findById(productId).orElse(null);
    }
}
