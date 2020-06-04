package spring.intro.model.dto;

import spring.intro.model.User;
import spring.intro.service.UserService;

public class UserResponseDto {
    private Long userId;
    private String name;

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public UserResponseDto convertUserIntoUserResponseDto(User user) {
        UserResponseDto userResponseDto = new UserResponseDto();
        userResponseDto.setUserId(user.getUserId());
        userResponseDto.setName(user.getName());
        return userResponseDto;
    }

    @Override
    public String toString() {
        return "User{" + "userId=" + userId + ", name='"
                + name + '\'' + '}';
    }
}
