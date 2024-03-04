package com.dropwizard.classes;

import java.util.List;
import java.util.ArrayList;

public class TaskService {

    private List<Task> tasks = new ArrayList<>();

    public void addTask(Task newTask) {
        if (tasks.stream().anyMatch(t -> t.getUniqueId().equals(newTask.getUniqueId()))) {
            throw new IllegalArgumentException("ID is not unique");
        }
        tasks.add(newTask);
    }

    public void deleteTask(String id) {
        tasks.removeIf(t -> t.getUniqueId().equals(id));
    }

    public void updateTaskNameById(String id, String name) {
        tasks.stream()
             .filter(t -> t.getUniqueId().equals(id))
             .findFirst()
             .ifPresent(t -> t.setName(name));
    }

    public void updateTaskDescription(String id, String description) {
        tasks.stream()
             .filter(t -> t.getUniqueId().equals(id))
             .findFirst()
             .ifPresent(t -> t.setDescription(description));
    }

    public Task getTaskById(String id) {
        return tasks.stream()
                    .filter(t -> t.getUniqueId().equals(id))
                    .findFirst()
                    .orElse(null);
    }

    public int size() {
        return tasks.size();
    }
}
