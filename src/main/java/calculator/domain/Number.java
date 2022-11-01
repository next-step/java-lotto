package calculator.domain;

import java.util.List;
import java.util.regex.Pattern;

public class Number {
    private static final String NEGATIVE_ERROR_MESSAGE = "음수가 들어왔습니다";
    private static final String TYPE_ERROR_MESSAGE = "숫자가 아닙니다.";
    private static final String NUMBER_REGEX = "[0-9]";

    private int value;

    public Number(){
        this(0);
    }

    public Number(int value){
        negativeChk(value);
        this.value = value;
    }

    public Number(String value){
        numberChk(value);
        negativeChk(Integer.parseInt(value));
        this.value = Integer.parseInt(value);
    }

    private void numberChk(String value){
        if(!Pattern.matches(NUMBER_REGEX,value)){
            throw new IllegalArgumentException(TYPE_ERROR_MESSAGE);
        }
    }

    private void negativeChk(int value){
        if(value < 0){
            throw new IllegalArgumentException(NEGATIVE_ERROR_MESSAGE);
        }
    }
}
