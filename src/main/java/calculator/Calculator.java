package calculator;

import calculator.domain.CalculatorDatas;
import calculator.domain.OperatorMap;

import java.util.List;

public class Calculator {

    private CalculatorDatas calculatorDatas;
    private OperatorMap operatorMap;

    public Calculator(String data){
        this.calculatorDatas = new CalculatorDatas(data);
        this.operatorMap = new OperatorMap();
    }

    public int startCalculate(){
        List<String> calculratorDatas = calculatorDatas.getCalculratorDatas();
        int number = Integer.parseInt(calculratorDatas.get(0));

        for(int i = 2; i < calculratorDatas.size(); i+=2){
            int nextNumber = Integer.parseInt(calculratorDatas.get(i));
            String sign = calculratorDatas.get(i - 1);
            number = operatorMap.calculate(sign, number, nextNumber);
        }

        return number;
    }
}
