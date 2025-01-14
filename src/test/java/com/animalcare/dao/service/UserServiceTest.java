package com.animalcare.service;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import com.animalcare.dao.UserDAO;
import com.animalcare.model.User;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class UserServiceTest {

    private UserService userService;
    private UserDAO mockUserDAO;

    @BeforeEach
    void setUp() {
        mockUserDAO = mock(UserDAO.class); // Mock the DAO
        userService = new UserService(mockUserDAO); // Inject the mock into the service
    }

    @Test
    void testRegisterUser_Success() {
        // Arrange
        User user = new User("Harsh", "harsh@example.com", "password123");
        when(mockUserDAO.saveUser(user)).thenReturn(true); // Mock behavior

        // Act
        boolean result = userService.registerUser(user);

        // Assert
        assertTrue(result);
        verify(mockUserDAO, times(1)).saveUser(user); // Verify DAO method was called
    }

    @Test
    void testRegisterUser_Failure_Validation() {
        // Arrange
        User user = new User(null, "harsh@example.com", "password123");

        // Act
        boolean result = userService.registerUser(user);

        // Assert
        assertFalse(result);
        verify(mockUserDAO, never()).saveUser(any()); // Ensure DAO method was not called
    }
}
