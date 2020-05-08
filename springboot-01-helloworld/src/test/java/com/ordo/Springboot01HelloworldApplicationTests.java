package com.ordo;

import com.ordo.pojo.Person;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class Springboot01HelloworldApplicationTests {

    @Autowired
    Person person = new Person();

    @Test
    void contextLoads() {
        System.out.println(person.toString());
    }

}
