package pl.sda.springbootdemo.domain.user;

import lombok.Getter;
import lombok.Setter;
import pl.sda.springbootdemo.domain.address.AddressDTO;

import java.util.List;

@Setter
@Getter
public class UserDTO {

    private Long id;
    private String firstName;
    private String lastName;
    private String login;
    private boolean active;

    private List<AddressDTO> addresses;

}
