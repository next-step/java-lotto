package calculator;

import java.util.InputMismatchException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static calculator.Calculation.*;

public class StringCalculator {
    private static final String SPACE_PATTERN = " ";
    private static final String OPERATION_REGULAR = "[+\\-*/]";
    private static final Pattern OPERATION_PATTERN = Pattern.compile(OPERATION_REGULAR);

    private String text;

    public StringCalculator(String text) {
        this.text = validateSpacing(text);
    }

    public boolean isFourBasicOperation(String sign) {
        Matcher m = OPERATION_PATTERN.matcher(sign);

        if(m.find()){
            return true;
        }
        throw new InputMismatchException("사칙연산 기호만 사용하여 주세요");
    }

    public String validateSpacing(String text) {
        if(text.strip().contains(SPACE_PATTERN)){
            return text;
        }
        throw new InputMismatchException("제대로 된 사칙연산을 공백을 포함하여 작성하여 주세요");
    }


    public String[] splitText() {
        return text.split(SPACE_PATTERN);
    }

    public int startOperation(String[] array) {
        int result = Integer.parseInt(array[0]);
        for(int i=1;i<array.length-1;i=i+2){
            isFourBasicOperation(array[i]);
            if(array[i].equals("+")) result = plus(result, Integer.parseInt(array[i+1]));
            if(array[i].equals("-")) result = subtract(result, Integer.parseInt(array[i+1]));
            if(array[i].equals("*")) result = multiply(result, Integer.parseInt(array[i+1]));
            if(array[i].equals("/")) result = divide(result, Integer.parseInt(array[i+1]));
        }
        return result;

    }
}
