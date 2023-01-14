package MenuApps.demo.service;

import MenuApps.demo.dto.CategoryDTO;
import MenuApps.demo.model.Category;

import java.util.List;

public interface CategoryService {
    Category create(Category category);
    Category update(Long id,Category category);
    Boolean delete(Long id);
    List<Category> findAll();
    Category findById(Long id);
    CategoryDTO mapToDTO(Category category);
    Category mapToEntity(CategoryDTO categoryDTO);
}
