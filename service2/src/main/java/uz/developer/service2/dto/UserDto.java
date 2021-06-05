package uz.developer.service2.dto;

import lombok.Data;
import uz.developer.service2.model.User;
import uz.developer.service2.model.enums.Gender;

@Data
public class UserDto {
    private Long id;
    private String username;
    private String userLastName;
    private String password;
    private String email;
    private String phoneNumber;
    private Gender gender;

    public UserDto(User user) {
        setId(user.getId());
        setUsername(user.getUsername());
        setUserLastName(user.getUserLastName());
        setPassword(user.getPassword());
        setEmail(user.getEmail());
        setPhoneNumber(user.getPhoneNumber());
        setGender(user.getGender());
    }

    public User convertToUser() {
        User user = new User();
        return convertToUser(user);
    }

    public User convertToUser(User user) {
        if (id != null)
            user.setId(id);
        user.setUsername(username);
        user.setUserLastName(userLastName);
        user.setPassword(password);
        user.setEmail(email);
        user.setPhoneNumber(phoneNumber);
        user.setGender(gender);
        return user;
    }

}
