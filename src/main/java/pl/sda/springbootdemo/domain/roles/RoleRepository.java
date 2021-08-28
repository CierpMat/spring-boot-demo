package pl.sda.springbootdemo.domain.roles;

import org.springframework.data.jpa.repository.JpaRepository;

import javax.management.relation.Role;

public interface RoleRepository extends JpaRepository<RoleEntity, Long> {

}
