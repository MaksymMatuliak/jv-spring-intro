package spring.intro.service;

import java.util.List;
import spring.intro.model.UserResponseDto;

public interface UserService {
    void add(UserResponseDto userResponseDto);

    List<UserResponseDto> listUsers();

    UserResponseDto get(Long id);
}
