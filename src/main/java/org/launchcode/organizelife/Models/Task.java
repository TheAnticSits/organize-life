package org.launchcode.organizelife.Models;

public class Task {
    private String task;
    private String importance;

    public Task(String taskName, String importance){
        this.task = taskName;
        this.importance = importance;
    }

    public String getTask() {
        return task;
    }

    public void setTask(String task) {
        this.task = task;
    }

    public String getImportance() {
        return importance;
    }

    public void setImportance(String importance) {
        this.importance = importance;
    }
}
