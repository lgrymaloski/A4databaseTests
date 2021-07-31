package com.jetbrains.databasetests;

import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface UsersRepository extends CrudRepository< Users, Long > {
    List<Users> findUsersByFirstName(String firstName);

    List<Users> findUsersByLastName(String lastName);

}
