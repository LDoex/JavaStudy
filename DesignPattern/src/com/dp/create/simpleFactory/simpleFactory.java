package com.dp.create.simpleFactory;

public class simpleFactory {
    public simpleFactory(){};
    public static Calculator getCalc(String param){
        if("+".equals(param)){
            return new AddCalculator();
        } else if("-".equals(param)){
            return new SubCalculator();
        } else if("*".equals(param)){
            return new MulCalculator();
        } else if("/".equals(param)){
            return new DivideCalculator();
        } else {
            throw new RuntimeException("不能计算");
        }
    }
}
