package uz.developer.service2.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import uz.developer.service2.model.User;
import uz.developer.service2.repository.UserRepository;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public ResponseEntity<String> saveUser(User user) {

        Optional<User> name = userRepository.findByUsername(user.getUsername());
        Optional<User> phone = userRepository.findByPhoneNumber(user.getPhoneNumber());
        if (name.isPresent()) {
            return ResponseEntity.ok("Bunday nomli foydalanuvchi mavjud!");
        } else if (phone.isPresent()) {
            return ResponseEntity.ok("Bunday telefon raqamli foydalanuvchi mavjud!");
        } else {
            userRepository.save(user);
            return ResponseEntity.ok("Foydalanuvchi saqlandi!");
        }

    }

    public ResponseEntity<String> delete(Long id) {
        Optional<User> user = userRepository.findById(id);

        if (!user.isPresent())
            return ResponseEntity.ok("Foydalanuvchi topilmadi!");
        userRepository.deleteById(id);
        return ResponseEntity.ok("Muvoffiqiyatli o'chirildi!");

    }

    public ResponseEntity<List<User>> getUsers() {
        List<User> userList = userRepository.findAll();
        return ResponseEntity.ok(userList);
    }


}
