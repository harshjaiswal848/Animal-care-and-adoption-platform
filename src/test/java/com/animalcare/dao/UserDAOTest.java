package com.animalcare.dao;

import static org.junit.jupiter.api.Assertions.*;

import com.animalcare.model.User;
import org.junit.jupiter.api.Test;

class UserDAOTest {

    private UserDAO userDAO = new UserDAO(); // Test the real DAO

    @Test
    void testSaveUser() {
        // Arrange
        User user = new User("Harsh", "harsh@example.com", "password123");

        // Act
        boolean result = userDAO.saveUser(user);

        // Assert
        assertTrue(result); // Simulate successful save
    }
}
