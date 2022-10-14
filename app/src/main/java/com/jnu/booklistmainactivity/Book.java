package com.jnu.booklistmainactivity;

public class Book {
    int id;
    String tittle;
     public int getCoverResourceId(){
        return id;
    }
    public String getTitle(){
         return tittle;
    }
    public void setCoverResourceId(int id){
         this.id=id;

    }
    public void setTitle(String title){
         this.tittle=title;

    }


}
