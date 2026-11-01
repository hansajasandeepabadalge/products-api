package uk.ac.westminster.products_api;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ProductService {
    private List<Product> products = new ArrayList<>();
    private Long nextId = 1L;

    public ProductService() {
        products.add(new DigitalProduct(nextId++, "Ebook of Everything", 10.00, "/book/ebook-of-everything", 5.00));
        products.add(new PhysicalProduct(nextId++, "Mouse", 5.00, 5.00, "5cm x 4cm x 2cm"));
        // products.add(new Product(nextId++, "Sample Product", 13.00));
    }

    public List<Product> getAllProducts() {
        return products;
    }

    public Product addProduct(Product product) {
        product.setId(nextId++);
        products.add(product);
        return product;
    }

    public Optional<Product> getProductById(Long id) {
        return products.stream().filter(p -> p.getId().equals(id)).findFirst();
    }

    public void deleteProduct(Long id){
        products.removeIf(p -> p.getId().equals(id));
    }

    public List<Product> findByName(String name) {
        return products.stream().filter(p->p.getName().contains(name)).toList();
    }

    public List<String> getAllSummaries() {
        List<String> summaries = new ArrayList<>();

        for (Product p : products) {
            summaries.add(p.getSummary());
        }

        return summaries;
    }
}