package org.launchcode.organizelife.Models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Date;


@Entity
public class Task {

    @Id
    @GeneratedValue
    private int id;

    private String taskName;

    private String importance;

    private double time;

    private Date date;

    public Task(){
        this.id = getId();
        this.taskName = taskName;
        this.importance = importance;
        this.time = time;


    }

    public int getId() {
        return id;
    }

    public String getTaskName() {
        return taskName;
    }

    public void setTaskName(String taskName) {
        this.taskName = taskName;
    }

    public String getImportance() {
        return importance;
    }

    public void setImportance(String importance) {
        this.importance = importance;
    }

    public double getTime() {
        return time;
    }

    public void setTime(double time) {
        this.time = time;
    }
}
