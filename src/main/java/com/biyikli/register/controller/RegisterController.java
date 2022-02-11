package com.biyikli.register.controller;

import com.biyikli.register.dto.UserDto;
import com.biyikli.register.service.IUserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

// Controller anotasyonu sayesinde sınıf, compenent scanning
// sürecinde, Spring container tarafından keşfedilebilir olacak.
@Controller
public class RegisterController {

    // Servis sınıfı için Dependency Injection
    @Autowired
    private IUserService userService;

    // Kayıt formunu içeren template'e dönen controller methodu.
    // GET HTTP methodu kullanıyor ve formdaki alanları,
    // UserDTO'nun alanlarıyla ilişkilendirmek için
    // model yapısını kullanıyor.
    @GetMapping("/user/register")
    public String showRegisterForm(Model model){

        // UserDto örneklendirilip, model'e ekleniyor.
        UserDto userDto = new UserDto();
        model.addAttribute("user", userDto);

        // Kayıt form template'ine dönüş yapılıyor.
        return "register-form";
    }

    // Kayıt anında tetiklenen controller methodu.
    // POST HTTP methodu kullanılıyor ve Form'a
    // girilen veri, yine model aracılığıyla methoda
    // ulaşıyor. BindingResult objemiz ise, ilgili
    // validasyona aykırı hataları içermekte.
    @PostMapping("/user/register")
    public String saveUser(@ModelAttribute("user") UserDto userDto, BindingResult bindingResult){

        // UserDto sınıfında, anotasyonlarla sağlanan
        // validasyon kurallarına aykırı bir durum
        // var ise ilgili hata ekrana yansıtılacak
        // şekilde, tekrar form template'ine dönüş
        // sağlanıyor.
        if(bindingResult.hasErrors()){
            return "register-form";
        }

        // Validasyonun başarılı olması halinde,
        // servis katmanına, ilgili form datası delegate
        // edilerek, kullanıcı kayıt yolculuğu başlıyor.
        userService.registerUser(userDto);

        // Kaydın başarılı olduğuna dair template'e dönüş
        // yapılıyor.
        return "success";

    }

}
