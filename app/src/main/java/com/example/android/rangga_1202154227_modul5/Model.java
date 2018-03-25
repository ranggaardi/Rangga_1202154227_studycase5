package com.example.android.rangga_1202154227_modul5;

/**
 * Created by ranggaardi on 3/25/2018.
 */

public class Model {
    private int id;
    private String name;
    private String desc;
    private String priority;

    public Model(){

    }

    public Model(String name, String desc, String priority){
        this.name = name;
        this.desc = desc;
        this.priority = priority;
    }

    public Model(int id, String name, String desc, String priority){
        this.id = id;
        this.name = name;
        this.desc = desc;
        this.priority = priority;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getDesc() {
        return desc;
    }

    public void setPriority(String priority) {
        this.priority = priority;
    }

    public String getPriority() {
        return priority;
    }
}
