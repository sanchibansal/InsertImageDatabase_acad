package com.example.sakshi.insertimagedatabase_acad;

import android.graphics.Bitmap;

/**
 * Created by sakshi on 9/9/2017.
 */

public class Data {
    private String id;
    private String name;
    private String age;
    public Bitmap employeePhoto;

    public Bitmap getEmployeePhoto() {
        return employeePhoto;
    }

    public void setEmployeePhoto(Bitmap employeePhoto) {
        this.employeePhoto = employeePhoto;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
