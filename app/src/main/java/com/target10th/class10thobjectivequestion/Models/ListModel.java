package com.target10th.class10thobjectivequestion.Models;

public class ListModel {

    String ChapterName ;
    String ChapterNo;
    String viewOnline;
    String hdPDF;


    public ListModel()
    {

    }


    public ListModel(String chapterName, String chapterNo, String viewOnline, String hdPDF) {
        ChapterName = chapterName;
        ChapterNo = chapterNo;
        this.viewOnline = viewOnline;
        this.hdPDF = hdPDF;
    }

    public String getChapterName() {
        return ChapterName;
    }

    public void setChapterName(String chapterName) {
        ChapterName = chapterName;
    }

    public String getChapterNo() {
        return ChapterNo;
    }

    public void setChapterNo(String chapterNo) {
        ChapterNo = chapterNo;
    }

    public String getViewOnline() {
        return viewOnline;
    }

    public void setViewOnline(String viewOnline) {
        this.viewOnline = viewOnline;
    }

    public String getHdPDF() {
        return hdPDF;
    }

    public void setHdPDF(String hdPDF) {
        this.hdPDF = hdPDF;
    }
}
