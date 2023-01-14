package MenuApps.demo.dto;

import MenuApps.demo.model.Category;

import java.util.List;

public record CategoryDTO(Long id, String name, String description, List<MenuDTO> menus)  {
}
