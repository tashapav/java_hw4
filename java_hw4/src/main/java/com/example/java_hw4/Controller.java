package com.example.java_hw4;

import com.example.java_hw4.request.RequestV1;
import com.example.java_hw4.request.RequestV2;
import com.example.java_hw4.request.RequestV3;
import com.example.java_hw4.response.ResponseV1;
import com.example.java_hw4.response.ResponseV2;
import com.example.java_hw4.response.ResponseV3;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Objects;

@RestController
@Validated
public class Controller {
    UserRepository userRepository;

    @Autowired
    Controller(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @GetMapping("/api/v1")
    public ResponseV1 responseV1(@Valid @RequestBody RequestV1 request) {
        if (request == null || request.getLike() == null) {
            request = new RequestV1("%");
        }
        ArrayList<String> login = new ArrayList<String>();
        String regexp = UserService.FromLikeToRegexp(request.getLike());
        for (User user : userRepository.users) {
            if (user.getLogin().matches(regexp)) {
                login.add(user.getLogin());
            }
        }
        return new ResponseV1(login);
    }

    @GetMapping("/api/v2")
    public ResponseV2 responseV2(@Valid @RequestBody RequestV1 request) {
        if (request == null || request.getLike() == null) {
            request = new RequestV1("%");
        }
        ArrayList<String> login = new ArrayList<String>();
        String regexp = UserService.FromLikeToRegexp(request.getLike());
        for (User user : userRepository.users) {
            if (user.getLogin().matches(regexp)) {
                login.add(user.getLogin());
            }
        }
        return new ResponseV2(userRepository.users.size(), login);
    }

    @GetMapping("/api/v3")
    public ResponseV3 responseV3(@Valid @RequestBody RequestV1 request) {
        if (request == null || request.getLike() == null) {
            request = new RequestV1("%");
        }
        ArrayList<String> login = new ArrayList<String>();
        ArrayList<ResponseV3.UserInfo> users = new ArrayList<ResponseV3.UserInfo>();
        String regexp = UserService.FromLikeToRegexp(request.getLike());
        for (User user : userRepository.users) {
            if (user.getLogin().matches(regexp)) {
                login.add(user.getLogin());
                ResponseV3.UserInfo addUser = new ResponseV3.UserInfo(user.getLogin(), user.getName(), user.getSurname());
                users.add(addUser);
            }
        }
        return new ResponseV3(userRepository.users.size(), login, users);
    }

    @GetMapping("/api/v4")
    public ResponseV3 responseV4(@Valid @RequestBody RequestV2 request) {
        if (request == null || request.getLike() == null) {
            request = new RequestV2("%", null);
        } else if (request.getRegex() == null) {
            request = new RequestV2("%", UserService.FromLikeToRegexp(request.getLike()));
        }
        ArrayList<String> login = new ArrayList<String>();
        ArrayList<ResponseV3.UserInfo> users = new ArrayList<ResponseV3.UserInfo>();
        String regexp = UserService.FromLikeToRegexp(request.getLike());
        for (User user : userRepository.users) {
            if (user.getLogin().matches(regexp)) {
                login.add(user.getLogin());
                ResponseV3.UserInfo addUser = new ResponseV3.UserInfo(user.getLogin(), user.getName(), user.getSurname());
                users.add(addUser);
            }
        }
        return new ResponseV3(userRepository.users.size(), login, users);
    }

    @GetMapping("/api/v5")
    public ResponseV3 responseV5(@Valid @RequestBody RequestV3 request) {
        if (request == null || request.getLike() == null) {
            request = new RequestV3("%", null, null, null, null);
        } else if (request.getRegex() == null) {
            request = new RequestV3("%", UserService.FromLikeToRegexp(request.getLike()), null, null, null);
        }
        ArrayList<String> login = new ArrayList<String>();
        ArrayList<ResponseV3.UserInfo> users = new ArrayList<ResponseV3.UserInfo>();
        String regexp = UserService.FromLikeToRegexp(request.getLike());
        for (User user : userRepository.users) {
            if (user.getLogin().matches(regexp) && (request.getSurname() == null ||
                    Objects.equals(user.getSurname(), request.getSurname())) &&
                    (request.getMinAge() == null || user.getAge() >= request.getMinAge()) &&
                    (request.getMaxAge() == null || user.getAge() <= request.getMaxAge())) {
                login.add(user.getLogin());
                users.add(new ResponseV3.UserInfo(user.getLogin(), user.getName(), user.getSurname()));
            }
        }
        return new ResponseV3(userRepository.users.size(), login, users);
    }
}
