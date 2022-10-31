package calculator.domain;

import calculator.Operator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class CalculatorDatas {

    private static final String NUMBER_NULL_ERROR_MESSAGE = "데이터가 없습니다";

    private List<String> calculratorDatas;

    public CalculatorDatas(String data) {
        nullChk(data);
        this.calculratorDatas = Arrays.asList(data.split(" "));
    }

    private void nullChk(String data){
        if(data == null || data.isBlank()){
            throw new IllegalArgumentException(NUMBER_NULL_ERROR_MESSAGE);
        }
    }

    public int startCalculator(){
        int number = Integer.parseInt(calculratorDatas.get(0));
        for(int i = 2; i < calculratorDatas.size(); i+=2){
            int nextNumber = Integer.parseInt(calculratorDatas.get(i));
            String sign = calculratorDatas.get(i - 1);
            number = Operator.calculate(sign, number, nextNumber);
        }

        return number;
    }

}




