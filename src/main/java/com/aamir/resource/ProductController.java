package com.aamir.resource;

import com.aamir.entity.Product;
import com.aamir.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.graphql.data.method.annotation.SubscriptionMapping;
import org.springframework.stereotype.Controller;

import java.util.List;
// if we are using GraphQL instead of RestAPI then do not need to use @RestController
@Controller
public class ProductController {

    @Autowired
    private ProductService service;

// Do not use @GetMapping for all kind of retrieval operation use @QueryMapping.
    @QueryMapping
    public List<Product> getProducts() {
        return service.getProducts();
    }

//  For passing any kind of argument use @Argument instead of @PathVariable
    @QueryMapping
    public List<Product> getProductsByCategory(@Argument String category) {
        return service.getProductsByCategory(category);
    }


    @MutationMapping
    public Product updateStock(@Argument int id, @Argument int stock) {
        return service.updateStock(id, stock);

    }

    @MutationMapping
    public Product receiveNewShipment(@Argument int id, @Argument int quantity) {
        return service.receiveNewShipment(id, quantity);

    }
}

