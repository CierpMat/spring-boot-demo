package pl.sda.springbootdemo.web.Controllers;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.sda.springbootdemo.domain.roles.RoleService;
import pl.sda.springbootdemo.domain.user.User;
import pl.sda.springbootdemo.domain.user.UserService;

import java.util.List;

@Controller
@RequestMapping("/mvc/users")
public class UserController {

    private final UserService userService;
    private final RoleService roleService;

    public UserController(UserService userService, RoleService roleService) {
        this.userService = userService;
        this.roleService = roleService;
    }

    @GetMapping
    @PreAuthorize("hasAuthority('ADMIN')")
    public String list(Model model) {
        List<User> allUsers = userService.getAllUsers();
        model.addAttribute("users", allUsers);
        return "usersList";
    }

    @GetMapping("/delete/{id}")
    @PreAuthorize("hasAuthority('ADMIN')")
    public String delete(@PathVariable Long id) {
        userService.delete(id);
        return "redirect:/mvc/users";
    }

    @GetMapping("/{id}")
    public String editUser(@PathVariable Long id, Model model) {
        model.addAttribute("user",userService.findById(id));
        model.addAttribute("roles", roleService.getRoles());
        return "editUser";
    }

    @PostMapping("/{id}")
    public String submitUser(@PathVariable Long id, User user) {
        user.setId(id);
        userService.save(user);
        return "redirect:/mvc/users";
    }

}
