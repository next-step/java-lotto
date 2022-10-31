package calculator;

import calculator.domain.CalculatorDatas;

import java.util.Arrays;
import java.util.List;

import static calculator.view.InputView.inputNumber;

public class Calculator {

    private CalculatorDatas calculatorDatas;

    public Calculator(List<String> datas){
        this.calculatorDatas = CalculatorDatas.numbersMake(Arrays.asList(inputNumber().split(" ")));
    }

    public int start(){
        return calculatorDatas.startCalculator();
    }
}
