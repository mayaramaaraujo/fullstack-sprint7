package br.com.rchlo.store.dto;

import br.com.rchlo.store.domain.ProductImage;

import java.util.List;
import java.util.stream.Collectors;

public class ProductImageDto {
  private String image_url;

  public ProductImageDto(ProductImage productImage) {
    this.image_url = productImage.getImageUrl();
  }

  public String getImage_url() {
    return image_url;
  }

  public static List<ProductImageDto> toConvert(List<ProductImage> productImages) {
    return productImages.stream().map(ProductImageDto::new).collect(Collectors.toList());
  }
}
