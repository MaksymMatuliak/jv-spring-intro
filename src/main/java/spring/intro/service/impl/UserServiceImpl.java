package spring.intro.service.impl;

import java.util.List;
import org.springframework.stereotype.Service;
import spring.intro.dao.UserDao;
import spring.intro.model.UserResponseDto;
import spring.intro.service.UserService;

@Service
public class UserServiceImpl implements UserService {
    private final UserDao userDao;

    public UserServiceImpl(UserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    public void add(UserResponseDto userResponseDto) {
        userDao.add(userResponseDto);
    }

    @Override
    public List<UserResponseDto> listUsers() {
        return userDao.getAll();
    }

    @Override
    public UserResponseDto get(Long id) {
        return userDao.get(id);
    }
}
