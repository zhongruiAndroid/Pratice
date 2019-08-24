package com.test.pratice.bean;

/***
 *   created by zhongrui on 2019/8/24
 */
public class Book {
    private int bookWidth;
    private int bookHeight;
    public double bookPrice;

    private long createTime;

    public Book() {
    }

    public Book(double bookPrice) {
        this.bookPrice = bookPrice;
    }

    public int getBookWidth() {
        return bookWidth;
    }

    public void setBookWidth(int bookWidth) {
        this.bookWidth = bookWidth;
    }

    public int getBookHeight() {
        return bookHeight;
    }

    public void setBookHeight(int bookHeight) {
        this.bookHeight = bookHeight;
    }
    private void setCreateTime(long time){
        this.createTime=time;
    }

    @Override
    public String toString() {
        return "Book{" +
                "bookWidth=" + bookWidth +
                ", bookHeight=" + bookHeight +
                ", bookPrice=" + bookPrice +
                ", createTime=" + createTime +
                '}';
    }
}
