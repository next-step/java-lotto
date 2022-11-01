package calculator;

import calculator.domain.CalculatorDatas;

public class Calculator {

    private CalculatorDatas calculatorDatas;

    public Calculator(String data){
        this.calculatorDatas = new CalculatorDatas(data);
    }

    public int start(){
        return calculatorDatas.startCalculate();
    }
}
