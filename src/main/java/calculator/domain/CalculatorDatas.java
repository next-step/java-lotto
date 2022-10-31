package calculator.domain;

import calculator.Operator;

import java.util.ArrayList;
import java.util.List;
public class CalculatorDatas {
    private static final String NUMBER_NULL_ERROR_MESSAGE = "데이터가 없습니다";
    private static final String REGEX = "^[0-9]*$";

    private List<String> calculratorDatas;

    public CalculatorDatas(List<String> data) {
        nullChk(data);
        this.calculratorDatas = data;
    }

    private void nullChk(List<String> numbers){
        if(numbers.isEmpty()){
            throw new IllegalArgumentException(NUMBER_NULL_ERROR_MESSAGE);
        }
    }

    public static CalculatorDatas numbersMake(List<String> datas){
        List<String> caculatorDatas = new ArrayList<>();
        for(String value : datas){
            caculatorDatas.add(value);
        }

        return new CalculatorDatas(caculatorDatas);
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




