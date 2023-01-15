package MenuApps.demo.controller;

import MenuApps.demo.dto.CategoryDTO;
import MenuApps.demo.model.Category;
import MenuApps.demo.service.CategoryService;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/category")
public class CategoryController {
    @Autowired
    CategoryService categoryService;
    @PostMapping("/create")
    public CategoryDTO create(@RequestBody CategoryDTO request){
        final Category category = categoryService.mapToEntity(request);
        final Category result = categoryService.create(category);
        return categoryService.mapToDTO(result);
    }
    @PutMapping("/update/{id}")
    public CategoryDTO update(@PathVariable Long id,@RequestBody CategoryDTO request){
        final Category category = categoryService.mapToEntity(request);
        final Category result = categoryService.update(id,category);
        return categoryService.mapToDTO(result);
    }
    @PatchMapping("/all")
    public List<CategoryDTO> findAll(){
        return categoryService.findAll().stream().map(category -> categoryService.mapToDTO(category))
                .collect(Collectors.toList());

    }
    @DeleteMapping("/delete/{id}")
    public Boolean delete(@PathVariable Long id){
        return categoryService.delete(id);
    }
}