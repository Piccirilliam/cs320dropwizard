package com.dropwizard.classes;

import static org.junit.Assert.assertEquals;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class TaskTest {

    @Test
    void createTask() {
        Task task = new Task("1234", "Clean Room", "Make bed, pick up laundry, fold clothes");
        assertEquals("1234", task.getUniqueId());
        assertEquals("Clean Room", task.getName());
        assertEquals("Make bed, pick up laundry, fold clothes", task.getDescription());
    }

    @Test
    void validateLongId() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            new Task("12345678901", "Clean Room", "Make bed, pick up laundry, fold clothes");
        });
    }

    @Test
    void validateNameLength() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            new Task("1234", "Room and Living Room Cleaning", "Make bed, pick up laundry, fold clothes");
        });
    }

    @Test
    void validateDescriptionLength() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            new Task("1234", "Clean Room", "Make bed, pick up laundry, fold clothes, vacuum and dusting");
        });
    }

    @Test
    void checkForNullId() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            new Task(null, "Clean Room", "Make bed, pick up laundry, fold clothes");
        });
    }

    @Test
    void checkForNullName() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            new Task("1234", null, "Make bed, pick up laundry, fold clothes");
        });
    }

    @Test
    void checkForNullDescription() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            new Task("1234", "Clean Room", null);
        });
    }
}