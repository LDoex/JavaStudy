package com.dp.create.factory;

public class Test {
    public static void main(String[] args) {
        CalcFactory factory = new AddFactory();
        Calculator cal = factory.getCalc();
        cal.num1 = 1;
        cal.num2 = 2;
        int result = cal.calc();
        System.out.println(result);
    }
}
