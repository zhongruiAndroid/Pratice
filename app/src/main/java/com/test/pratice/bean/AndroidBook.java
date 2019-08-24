package com.test.pratice.bean;

/***
 *   created by zhongrui on 2019/8/24
 */
public class AndroidBook extends Book {
    private int androidBookWidth;
    private int androidBookHeight;
    public double androidBookPrice;

    private long androidCreateTime;

    public AndroidBook() {
    }

    public AndroidBook(double androidBookPrice) {
        this.androidBookPrice = androidBookPrice;
    }

    public int getAndroidBookWidth() {
        return androidBookWidth;
    }

    public void setAndroidBookWidth(int androidBookWidth) {
        this.androidBookWidth = androidBookWidth;
    }

    public int getAndroidBookHeight() {
        return androidBookHeight;
    }

    public void setAndroidBookHeight(int androidBookHeight) {
        this.androidBookHeight = androidBookHeight;
    }

    public double getAndroidBookPrice() {
        return androidBookPrice;
    }

    public void setAndroidBookPrice(double androidBookPrice) {
        this.androidBookPrice = androidBookPrice;
    }

    public long getAndroidCreateTime() {
        return androidCreateTime;
    }

    public void setAndroidCreateTime(long androidCreateTime) {
        this.androidCreateTime = androidCreateTime;
    }

    @Override
    public String toString() {
        return "AndroidBook{" +
                "androidBookWidth=" + androidBookWidth +
                ", androidBookHeight=" + androidBookHeight +
                ", androidBookPrice=" + androidBookPrice +
                ", androidCreateTime=" + androidCreateTime +
                '}';
    }
}
