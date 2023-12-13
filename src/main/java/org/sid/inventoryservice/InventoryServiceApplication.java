package org.sid.inventoryservice;

import org.sid.inventoryservice.entities.Product;
import org.sid.inventoryservice.repositories.ProductRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;
import org.springframework.data.rest.webmvc.RepositoryRestController;

import java.util.List;

@SpringBootApplication
public class InventoryServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(InventoryServiceApplication.class, args);
    }


    @Bean
    CommandLineRunner start(ProductRepository productRepository, RepositoryRestConfiguration repositoryRestConfiguration){
        return args -> {

            repositoryRestConfiguration.exposeIdsFor(Product.class);
            productRepository.saveAll(

                    List.of(
                            Product.builder()
                                    .name("computer")
                                    .quantity(12)
                                    .price(1400D)
                                    .build(),
                            Product.builder()
                                    .name("iphone")
                                    .quantity(10)
                                    .price(1300D)
                                    .build(),
                            Product.builder()
                                    .name("macbook")
                                    .quantity(9)
                                    .price(2000D)
                                    .build()
                    )
            );

        };
    }
}
