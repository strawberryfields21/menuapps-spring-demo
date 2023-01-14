package MenuApps.demo.service;

import MenuApps.demo.dto.CategoryDTO;
import MenuApps.demo.model.Category;
import MenuApps.demo.repository.CategoryRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class CategoryServiceImpl implements CategoryService{
    @Autowired
    CategoryRepository categoryRepository;
    @Override
    public Category create(Category category) {
        categoryRepository.save(category);
        return category;
    }

    @Override
    public Category update(Long id, Category category) {

        final Category result = findById(id);
        if (result != null){
            result.setName(category.getName());
            result.setDescription(category.getDescription());
            categoryRepository.save(result);
            return result;
        }


        return null;
    }

    @Override
    public Boolean delete(Long id) {
        final Category result = findById(id);
        if (result != null  ){
            categoryRepository.deleteById(id);
            return true;
        }
        return false;
    }

    @Override
    public List<Category> findAll() {
        return categoryRepository.findAll();
    }

    @Override
    public Category findById(Long id) {
        Optional<Category> result = categoryRepository.findById(id);
        return result.orElse(null);
    }

    ObjectMapper mapper = new ObjectMapper();
    @Override
    public CategoryDTO mapToDTO(Category category) {
        return mapper.convertValue(category,CategoryDTO.class);
    }

    @Override
    public Category mapToEntity(CategoryDTO categoryDTO) {
        return mapper.convertValue(categoryDTO,Category.class);
    }
}
