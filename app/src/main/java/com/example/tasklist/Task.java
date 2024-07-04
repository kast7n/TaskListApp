package com.example.tasklist;

import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

public class Task implements Parcelable {

    private String taskTitle;
    private String taskDuration;
    private String taskDescription;
    private String taskDueDate;
    private String taskCategory;

    public Task(String taskTitle, String taskDuration, String taskDescription, String taskDueDate, String taskCategory) {
        this.taskTitle = taskTitle;
        this.taskDuration = taskDuration;
        this.taskDescription = taskDescription;
        this.taskDueDate = taskDueDate;
        this.taskCategory = taskCategory;
    }

    protected Task(Parcel in) {
        taskTitle = in.readString();
        taskDuration = in.readString();
        taskDescription = in.readString();
        taskDueDate = in.readString();
        taskCategory = in.readString();
    }

    public static final Creator<Task> CREATOR = new Creator<Task>() {
        @Override
        public Task createFromParcel(Parcel in) {
            return new Task(in);
        }

        @Override
        public Task[] newArray(int size) {
            return new Task[size];
        }
    };

    public String getTaskTitle() {
        return taskTitle;
    }

    public void setTaskTitle(String taskTitle) {
        this.taskTitle = taskTitle;
    }

    public String getTaskDuration() {
        return taskDuration;
    }

    public void setTaskDuration(String taskDuration) {
        this.taskDuration = taskDuration;
    }

    public String getTaskDescription() {
        return taskDescription;
    }

    public void setTaskDescription(String taskDescription) {
        this.taskDescription = taskDescription;
    }

    public String getTaskDueDate() {
        return taskDueDate;
    }

    public void setTaskDueDate(String taskDueDate) {
        this.taskDueDate = taskDueDate;
    }

    public String getTaskCategory() {
        return taskCategory;
    }

    public void setTaskCategory(String taskCategory) {
        this.taskCategory = taskCategory;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(@NonNull Parcel parcel, int i) {
        parcel.writeString(taskTitle);
        parcel.writeString(taskDuration);
        parcel.writeString(taskDescription);
        parcel.writeString(taskDueDate);
        parcel.writeString(taskCategory);
    }
}
