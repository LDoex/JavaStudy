package com.dp.create.factory;


public class AddCalculator extends Calculator {
    @Override
    public int calc() {
        return num1+num2;
    }
}

class SubCalculator extends Calculator {
    @Override
    public int calc() {
        return num1-num2;
    }
}

class MulCalculator extends Calculator {
    @Override
    public int calc() {
        return num1*num2;
    }
}

class DivideCalculator extends Calculator {
    @Override
    public int calc() {
        if(num2 != 0){
            return num1/num2;
        } else {
            throw new RuntimeException("除数不能为零");
        }
    }
}
