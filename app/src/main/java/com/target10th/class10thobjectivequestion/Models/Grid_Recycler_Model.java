package com.target10th.class10thobjectivequestion.Models;

public class Grid_Recycler_Model {


    public Grid_Recycler_Model()
    {

    }

   String BookName;
   String ImgUrl;
   String DB;

    public Grid_Recycler_Model(String bookName, String imgUrl, String DB) {
        BookName = bookName;
        ImgUrl = imgUrl;
        this.DB = DB;
    }

    public String getBookName() {
        return BookName;
    }

    public void setBookName(String bookName) {
        BookName = bookName;
    }

    public String getImgUrl() {
        return ImgUrl;
    }

    public void setImgUrl(String imgUrl) {
        ImgUrl = imgUrl;
    }

    public String getDB() {
        return DB;
    }

    public void setDB(String DB) {
        this.DB = DB;
    }
}
