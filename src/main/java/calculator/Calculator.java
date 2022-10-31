package calculator;

import calculator.domain.CalculatorDatas;

import java.util.Arrays;
import java.util.List;

import static calculator.view.InputView.inputNumber;

public class Calculator {

    private CalculatorDatas calculatorDatas;

    public Calculator(String data){
        this.calculatorDatas = CalculatorDatas.numbersMake(data);
    }

    public int start(){
        return calculatorDatas.startCalculator();
    }
}
