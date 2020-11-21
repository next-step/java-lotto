package calculator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class InputCheckor {

    private String text;
    private String delimiter;

    public String getText(){
        return text;
    }
    public String getDelimiter(){
        return delimiter;
    }

    //기본형태로 셋팅
    public InputCheckor(String input){
        this.text = input;
        this.delimiter = ",|:";

    }

    //커스텀 구분자가 있는지 확인후 셋팅 한다.
    public void findDelimiterAndText(String input){

        Matcher m = Pattern.compile("//(.)\n(.*)").matcher(input);
        if(m.find()){
            delimiter = m.group(1);
            text = m.group(2);
        }
        checkInputValidation(text);

    }
    //음수가 있는지 확인
    public static void checkInputValidation(String text){
        Matcher m = Pattern.compile("\\-\\d").matcher(text);
        if(m.find()){
            throw new RuntimeException();
        }
    }







}
