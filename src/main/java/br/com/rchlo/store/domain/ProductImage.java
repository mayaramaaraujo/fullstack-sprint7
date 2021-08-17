package br.com.rchlo.store.domain;

import javax.persistence.*;

@Entity
public class ProductImage {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "product_code")
    private Product product;

    private String imageUrl;

    public Long getId() {
        return id;
    }

    public Product getProduct() {
        return product;
    }

    public String getImageUrl() {
        return imageUrl;
    }
}
