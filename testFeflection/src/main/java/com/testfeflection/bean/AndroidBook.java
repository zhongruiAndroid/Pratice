package com.testfeflection.bean;

/***
 *   created by zhongrui on 2019/8/24
 */
public class AndroidBook extends Book {
    private int androidBookWidth;
    private int androidBookHeight;
    public double androidBookPrice;
    protected String protectedA;
    String b;

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
    private void testa(){
        System.out.println("testa");
    }
    protected void testb(){

        System.out.println("testb");
    }
    void testc(){

        System.out.println("testc");
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
