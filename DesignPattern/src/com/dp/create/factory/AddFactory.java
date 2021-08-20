package com.dp.create.factory;

public class AddFactory implements CalcFactory{

    @Override
    public Calculator getCalc() {
        return new AddCalculator();
    }
}

class SubFactory implements CalcFactory{
    @Override
    public Calculator getCalc() {
        return new SubCalculator();
    }
}

class MutFactory implements CalcFactory{

    @Override
    public Calculator getCalc() {
        return new MulCalculator();
    }
}

class DivideFactory implements CalcFactory{

    @Override
    public Calculator getCalc() {
        return new DivideCalculator();
    }
}