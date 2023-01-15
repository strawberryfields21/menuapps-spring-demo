package MenuApps.demo.service;

import MenuApps.demo.dto.MenuDTO;
import MenuApps.demo.model.Category;
import MenuApps.demo.model.Menu;
import MenuApps.demo.repository.CategoryRepository;
import MenuApps.demo.repository.MenuRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MenuServiceImpl implements MenuService{
    @Autowired
    MenuRepository menuRepository;
    @Autowired
    CategoryRepository categoryRepository;
    @Override
    public Menu create(Menu menu,Long category_id) {

        Optional<Category> category = categoryRepository.findById(category_id);
        if (category != null) {
            Menu newData = new Menu();
            newData = menu;
            newData.setCategory(category.get());
            menuRepository.save(newData);
        }

        return menu;
    }

    @Override
    public Menu update(Long id, Menu menu) {
        final Menu result = findById(id);
        if (result != null){
            result.setName(menu.getName());
            result.setDescription(menu.getDescription());
            result.setPrice(menu.getPrice());
            menuRepository.save(result);
            return result;
        }


        return null;
    }

    @Override
    public Boolean delete(Long id) {
        final Menu result = findById(id);
        if (result != null  ){
            menuRepository.deleteById(id);
            return true;
        }
        return false;
    }

    @Override
    public List<Menu> findAll() {
        List<Menu> menu = menuRepository.findAll();
        return menu;
    }

    @Override
    public Menu findById(Long id) {
        Optional<Menu> result = menuRepository.findById(id);
        return result.orElse(null);
    }

    ObjectMapper mapper = new ObjectMapper();
    @Override
    public MenuDTO mapToDTO(Menu menu) {
        return mapper.convertValue(menu, MenuDTO.class);
    }

    @Override
    public Menu mapToEntity(MenuDTO menuDTO) {
        return mapper.convertValue(menuDTO,Menu.class);
    }
}
