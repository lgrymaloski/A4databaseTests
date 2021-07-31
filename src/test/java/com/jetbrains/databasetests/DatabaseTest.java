package com.jetbrains.databasetests;

import com.jetbrains.databasetests.UsersRepository;
import com.jetbrains.databasetests.Users;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;


@SpringBootTest(classes = Application.class)
@DirtiesContext(classMode = DirtiesContext.ClassMode.BEFORE_EACH_TEST_METHOD)
public class DatabaseTest {
    @Autowired
    private UsersRepository usersRepository;

    @BeforeEach
    public void setUp(){
    }

    @Test
    public void addUserTest(){
        Users new_user = new Users("John", "Doe", "jDoe", "password", 0);
        usersRepository.save(new_user);
        assertEquals(usersRepository.count(), 1);
    }

    @Test
    public void addMultipleUserTest(){
        Users user1 = new Users("John", "Doe", "jDoe", "password", 0);
        usersRepository.save(user1);
        Users user2 = new Users("Amy", "Smith", "aSmith", "helloworld123", 0);
        usersRepository.save(user2);
        Users user3 = new Users("Luca", "Brown", "lBrown", "summer#8910", 0);
        usersRepository.save(user3);

        assertEquals(usersRepository.count(), 3);
    }

    @Test
    public void readUserTest(){
        Users new_user = new Users("John", "Doe", "jDoe", "password", 0);
        usersRepository.save(new_user);
        assertEquals(usersRepository.count(), 1);

        Users user = usersRepository.findUsersByFirstName("John").get(0);
        assertEquals(user, new_user);
    }

    @Test
    public void readWithMultipleUserTest(){
        Users user1 = new Users("John", "Doe", "jDoe", "password", 0);
        usersRepository.save(user1);
        Users user2 = new Users("Amy", "Smith", "aSmith", "helloworld123", 0);
        usersRepository.save(user2);
        Users user3 = new Users("Luca", "Brown", "lBrown", "summer#8910", 0);
        usersRepository.save(user3);

        Users user = usersRepository.findUsersByFirstName("Amy").get(0);
        assertEquals(user, user2);
    }

    @Test
    public void updateUserTest(){
        Users new_user = new Users("John", "Doe", "jDoe", "password", 0);
        usersRepository.save(new_user);
        assertEquals(usersRepository.count(), 1);

        Users user = usersRepository.findUsersByFirstName("John").get(0);
        user.setAdminAccess(1);
        usersRepository.save(user);

        assertEquals(usersRepository.findUsersByFirstName("John").get(0).adminAccess(), 1);
    }

    @Test
    public void updateMultipleUserTest(){
        Users user1 = new Users("John", "Doe", "jDoe", "password", 0);
        usersRepository.save(user1);
        Users user2 = new Users("Amy", "Smith", "aSmith", "helloworld123", 0);
        usersRepository.save(user2);
        Users user3 = new Users("Luca", "Brown", "lBrown", "summer#8910", 0);
        usersRepository.save(user3);

        assertEquals(usersRepository.count(), 3);

        Users user = usersRepository.findUsersByFirstName("John").get(0);
        user.setAdminAccess(1);
        usersRepository.save(user);

        assertEquals(usersRepository.findUsersByFirstName("John").get(0).adminAccess(), 1);
    }

    @Test
    public void removeUserTest(){
        Users new_user = new Users("John", "Doe", "jDoe", "password", 0);
        usersRepository.save(new_user);
        assertEquals(usersRepository.count(), 1);

        usersRepository.delete(new_user);
        assertEquals(usersRepository.count(), 0);
    }

    @Test
    public void removeMultipleUserTest(){
        Users user1 = new Users("John", "Doe", "jDoe", "password", 0);
        usersRepository.save(user1);
        Users user2 = new Users("Amy", "Smith", "aSmith", "helloworld123", 0);
        usersRepository.save(user2);
        Users user3 = new Users("Luca", "Brown", "lBrown", "summer#8910", 0);
        usersRepository.save(user3);
        assertEquals(usersRepository.count(), 3);

        usersRepository.delete(user1);
        assertEquals(usersRepository.count(), 2);
        usersRepository.delete(user2);
        assertEquals(usersRepository.count(), 1);
        usersRepository.delete(user3);
        assertEquals(usersRepository.count(), 0);
    }

}
