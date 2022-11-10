package calculator.view;

import calculator.util.StringUtil;

import java.util.List;
import java.util.Scanner;

public class InputView {
    private static final Scanner SCANNER = new Scanner(System.in);
    private static final StringUtil STRING_UTIL = new StringUtil();

    public InputView() {
    }
    public List<String> getInputString(){
        String inputString = SCANNER.nextLine();
        if(!isRightInput(inputString)){
            throw new IllegalArgumentException("올바르지 않은 입력값입니다.");
        }
        return STRING_UTIL.splitString(inputString);
    }

    private boolean isRightInput(String inputString){
        if(STRING_UTIL.isNullOrEmpty(inputString)||!STRING_UTIL.isRightString(inputString)){
            return false;
        }
        return true;
    }
}
