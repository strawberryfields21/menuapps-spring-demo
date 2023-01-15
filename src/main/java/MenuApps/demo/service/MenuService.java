package MenuApps.demo.service;

import MenuApps.demo.dto.CategoryDTO;
import MenuApps.demo.dto.MenuDTO;
import MenuApps.demo.model.Category;
import MenuApps.demo.model.Menu;

import java.util.List;

public interface MenuService {
    Menu create (Menu menu,Long category_id);
    Menu update (Long id,Menu menu);
    Boolean delete(Long id);
    List<Menu> findAll();
    Menu findById(Long id);
    MenuDTO mapToDTO(Menu menu);
    Menu mapToEntity(MenuDTO menuDTO);
}
