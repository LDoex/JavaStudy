package com.dp.create.simpleFactory;

/**
 * 运算父类
 */
public abstract class Calculator {
    protected int num1;
    protected int num2;

    public Calculator(){

    }

    public Calculator(int num1, int num2) {
        this.num1 = num1;
        this.num2 = num2;
    }

    public int getNum1() {
        return num1;
    }

    public void setNum1(int num1) {
        this.num1 = num1;
    }

    public int getNum2() {
        return num2;
    }

    public void setNum2(int num2) {
        this.num2 = num2;
    }

    //抽象方法，不同运算方法实现不同
    public abstract int calc();
}
