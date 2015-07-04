package ru.javabegin.training.web.beans;

import java.io.Serializable;

public class Genre implements Serializable {

    private String name;
    private long id;

    public Genre() {
    }

    public Genre(String name, long id) {
        this.name = name;
        this.id = id;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
