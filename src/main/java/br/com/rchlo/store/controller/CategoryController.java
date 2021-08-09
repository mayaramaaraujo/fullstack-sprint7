package br.com.rchlo.store.controller;

import br.com.rchlo.store.controller.dto.CategoryDto;
import br.com.rchlo.store.domain.Category;
import br.com.rchlo.store.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CategoryController {
    @Autowired
    private CategoryRepository categoryRepository;

    @RequestMapping("/categorias")
    public List<CategoryDto> orderByPosition() {
        List<Category> categories = categoryRepository.findAllByOrderByPosition();
        return CategoryDto.toConvert(categories);
    }

}
