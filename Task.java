package com.dropwizard.classes;

public class Task {

    private String uniqueId;
    private String name;
    private String description;

    public Task(String uniqueId, String name, String description) {
        validateInputs(uniqueId, 10, "Invalid uniqueId");
        validateInputs(name, 20, "Invalid Task Name");
        validateInputs(description, 50, "Invalid Task Description");

        this.uniqueId = uniqueId;
        this.name = name;
        this.description = description;
    }

    private void validateInputs(String input, int maxLength, String errorMsg) {
        if (input == null || input.length() > maxLength) {
            throw new IllegalArgumentException(errorMsg);
        }
    }

    public String getUniqueId() {
        return uniqueId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        validateInputs(name, 20, "Invalid Task Name");
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        validateInputs(description, 50, "Invalid Description");
        this.description = description;
    }
}
