package com.dp.create.simpleFactory;

public class Test {
    public static void main(String[] args) {
        Calculator calculator = simpleFactory.getCalc("/");
        calculator.num1 = 1;
        calculator.num2 = 10;
        int result = calculator.calc();
        System.out.println(result);
    }
}
