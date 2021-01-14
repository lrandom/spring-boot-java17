package com.example.demo.models;

import lombok.Data;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Data
@Component
public class User {
    public String id;
    public String name;
    public String fullname;
    public String address;
    public String password;
}
