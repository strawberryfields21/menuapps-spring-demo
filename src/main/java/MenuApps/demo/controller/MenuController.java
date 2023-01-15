package MenuApps.demo.controller;

import MenuApps.demo.dto.CategoryDTO;
import MenuApps.demo.dto.MenuDTO;
import MenuApps.demo.model.Category;
import MenuApps.demo.model.Menu;
import MenuApps.demo.service.CategoryService;
import MenuApps.demo.service.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/menu")
public class MenuController {
    @Autowired
    MenuService menuService;
    @PostMapping("/create")
    public MenuDTO create(@RequestBody MenuDTO request){
        final Menu menu = menuService.mapToEntity(request);
        final Menu result = menuService.create(menu,request.category());
        return menuService.mapToDTO(result);
    }
    @PutMapping("/update/{id}")
    public MenuDTO update(@PathVariable Long id,@RequestBody MenuDTO request){
        final Menu menu = menuService.mapToEntity(request);
        final Menu result = menuService.update(id,menu);
        return menuService.mapToDTO(result);
    }
    @PatchMapping("/all")
    public List<MenuDTO> findAll(){
        return menuService.findAll().stream().map(menu -> menuService.mapToDTO(menu))
                .collect(Collectors.toList());

    }
    @DeleteMapping("/delete/{id}")
    public Boolean delete(@PathVariable Long id){
        return menuService.delete(id);
    }
}
