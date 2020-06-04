package spring.intro.dao;

import java.util.List;
import spring.intro.model.UserResponseDto;

public interface UserDao {
    void add(UserResponseDto userResponseDto);

    List<UserResponseDto> getAll();

    UserResponseDto get(Long id);
}
