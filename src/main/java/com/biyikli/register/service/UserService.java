package com.biyikli.register.service;

import com.biyikli.register.dto.UserDto;
import com.biyikli.register.entity.User;
import com.biyikli.register.repository.IUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service

public class UserService implements IUserService{

    // Repository için Dependency Injection.
    @Autowired
    private IUserRepository userRepository;

    @Override
    // Datasource için bağlantı açan Transactional anotasyonu.
    // Bu anotasyon, rollback gibi avantajlar sağlamakta ve
    // devam ettiği sürece, db'ye commit gerçekleştirebiliriz.
    @Transactional
    // kullanıcı kaydı için servis methodu. Parametre olarak
    // formdan gelen veriyi, userDto olarak alıyor.
    public User registerUser(final UserDto userDto) {

        // dto objemizi kullanarak yeni bir User objesi oluşturuyoruz.
        User user = new User();
        user.setName(userDto.getName());
        user.setEmail(userDto.getEmail());
        user.setPassword(userDto.getPassword());

        // dao ya da repo katmanına kayıt için, bu katmanın
        // save() methodunu çağırıyoruz. Bu method runtime
        // sırasında oluşuyor ve CrudRepository tarafından sağlanılıyor
        return userRepository.save(user);
    }

    private boolean emailExists(String email){
        return userRepository.findByEmail(email) != null;
    }
}
