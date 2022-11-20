package calculator.domain;

import java.util.Arrays;
import java.util.List;

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

    public List<String> getCalculratorDatas(){
        return this.calculratorDatas;
    }
}