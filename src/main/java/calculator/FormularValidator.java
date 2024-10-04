package calculator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Pattern;

public class FormularValidator {
    private static List<String> OPERATORS = Arrays.asList("+","-","*","/");
    private static String REGEXP_PATTERN_NUMBER = "^[\\d]*$";

    public static void validate(String[] formularTokens) {

        for(int j=0; j < formularTokens.length ; j=j+2  ){
            checkOperand(formularTokens[j]);
        }
        checkOperand(formularTokens[formularTokens.length-1]);

        for(int i=1; i < formularTokens.length ; i=i+2) {
                checkOperator(formularTokens[i]);
        }

    }
    private static void checkOperand(String formularToken) {
        if(Pattern.matches(REGEXP_PATTERN_NUMBER, formularToken)){
            return ;
        }
        throw new IllegalArgumentException("입력 산식 피연산자 오류");
    }

    private static void checkOperator(String formularToken) {
        if (OPERATORS.contains(formularToken)) {
            return ;
        }
        throw new IllegalArgumentException("입력 산식 연산자 오류");
    }
}
