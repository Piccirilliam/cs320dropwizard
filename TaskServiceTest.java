package com.dropwizard.classes;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class TaskServiceTest {

    private TaskService taskService;

    @BeforeEach
    void initialize() {
        taskService = new TaskService();
    }

    @Test
    void addTaskBehavior() {
    }

    @Test
    void removeTaskBehavior() {
    }

    @Test
    void modifyTaskBehavior() {
    }

    @Test
    void verifySize() {
        assertEquals(0, taskService.size());

        Task firstTask = new Task("1234", "Clean Car", "Wipe windows");
        Task secondTask = new Task("1235", "Clean Room", "Make bed, pick up laundry, fold clothes");

        taskService.addTask(firstTask);
        taskService.addTask(secondTask);

        assertEquals(2, taskService.size());

        taskService.deleteTask("1234");
        assertEquals(1, taskService.size());

        taskService.deleteTask("1235");
        assertEquals(0, taskService.size());
    }

    @Test
    void validateAddAndUpdate() {
        assertEquals(0, taskService.size());

        Task thirdTask = new Task("1234", "Clean Room", "Make bed, pick up laundry, fold clothes");
        taskService.addTask(thirdTask);
        assertEquals(1, taskService.size());

        taskService.updateTaskNameById("1234", "Clean Living Room");
        taskService.updateTaskDescription("1234", "Clean couch, vacuum rug");

        Task modifiedTask = taskService.getTaskById("1234");
        assertEquals("Clean Living Room", modifiedTask.getName());
        assertEquals("Clean couch, vacuum rug", modifiedTask.getDescription());
    }
}