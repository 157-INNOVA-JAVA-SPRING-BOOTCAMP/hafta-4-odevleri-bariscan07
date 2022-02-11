package com.biyikli.register.repository;

import com.biyikli.register.entity.User;
import org.springframework.data.repository.CrudRepository;

// Repository interface'i. CrudRepository'i extend ederek gerekli CRUD methodlarını
// kullanmamıza olanak sağlıyor.
public interface IUserRepository extends CrudRepository<User, Long> {

    // email'ine göre kullanıcıyı bulmamızı sağlayan method tanımı.
    User findByEmail(String email);
}
