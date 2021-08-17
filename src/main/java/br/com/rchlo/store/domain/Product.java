package br.com.rchlo.store.domain;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Product {

    @Id
    private Long code;

    private String name;

    private String description;

    private String slug;

    private String brand;

    private BigDecimal price;

    private BigDecimal discount;

    @Enumerated(EnumType.STRING)
    private Color color;

    private Integer weightInGrams;

    @OneToMany(mappedBy = "product", cascade = CascadeType.ALL)
    private List<ProductImage> productImage = new ArrayList<>();

    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category category;

//    private List<Size> availableSizes;

    /** @deprecated */
    protected Product() {
    }

    public Product(Long code, String name, String description, String slug, String brand, BigDecimal price, BigDecimal discount, Color color, Integer weightInGrams, List<ProductImage> productImage, Category category) {
        this.code = code;
        this.name = name;
        this.description = description;
        this.slug = slug;
        this.brand = brand;
        this.price = price;
        this.discount = discount;
        this.color = color;
        this.weightInGrams = weightInGrams;
        this.productImage = productImage;
        this.category = category;
    }

    public Long getCode() {
        return code;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }


    public Category getCategory() {
        return category;
    }

    public String getSlug() {
        return slug;
    }

    public String getBrand() {
        return brand;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public BigDecimal getDiscount() {
        return discount;
    }

    public Color getColor() {
        return color;
    }

    public Integer getWeightInGrams() {
        return weightInGrams;
    }

    public List<ProductImage> getProductImage() {
        return productImage;
    }
}
