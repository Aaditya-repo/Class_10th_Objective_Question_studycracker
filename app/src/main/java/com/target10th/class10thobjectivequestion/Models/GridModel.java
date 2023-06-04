package com.target10th.class10thobjectivequestion.Models;

public class GridModel {

    private String course_name;
    private int imgid;
    private String db_name;

    public GridModel(String course_name, int imgid, String db_name) {
        this.course_name = course_name;
        this.imgid = imgid;
        this.db_name = db_name;
    }

    public String getCourse_name() {
        return course_name;
    }

    public void setCourse_name(String course_name) {
        this.course_name = course_name;
    }

    public int getImgid() {
        return imgid;
    }

    public void setImgid(int imgid) {
        this.imgid = imgid;
    }

    public String getDb_name() {
        return db_name;
    }

    public void setDb_name(String db_name) {
        this.db_name = db_name;
    }
}
