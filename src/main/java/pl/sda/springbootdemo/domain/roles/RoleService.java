package pl.sda.springbootdemo.domain.roles;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoleService {
    private final RoleRepository roleRepository;

    public RoleService(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }

    public List<RoleEntity> getRoles() {
        return roleRepository.findAll();
    }

}
