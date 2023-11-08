package calculator.domain;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringCalculator {

    private static final String OPERATION_REGULAR = "[+\\-*/]";
    private static final Pattern OPERATION_PATTERN = Pattern.compile(OPERATION_REGULAR);

    private List<Integer> numberList;
    private List<String> operationList;


    public StringCalculator(String[] textArray) {
        this.numberList = new ArrayList<>();
        this.operationList = new ArrayList<>();
        splitText(textArray);

    }

    private void splitText(String[] textArray) {

        for (int i = 0; i < textArray.length; i++) {
            separateNumberAndSign(textArray[i], i);
        }
    }

    private void separateNumberAndSign(String text, int i) {
        if (isEven(i)) {
            numberList.add(checkNumber(text));
        }
        if (isOdd(i)) {
            operationList.add(checkFourBasicOperation(text));

        }
    }

    private int checkNumber(String text) {
        try {
            return Integer.parseInt(text);
        } catch (InputMismatchException err) {
            throw new InputMismatchException("숫자만 사칙연산이 가능합니다");
        }
    }


    private String checkFourBasicOperation(String sign) {
        Matcher m = OPERATION_PATTERN.matcher(sign);

        if (m.find()) {
            return sign;
        }
        throw new InputMismatchException("사칙연산 기호만 사용하여 주세요");
    }


    public int startOperation() {
        int result = numberList.get(0);
        for (int i = 0; i < operationList.size(); i++) {
            Operation operation = Operation.findOperationBySign(operationList.get(i));
            operation.calculate(result, numberList.get(i + 1));
        }
        return result;

    }


    private static boolean isOdd(int i) {
        return i % 2 == 1;
    }

    private static boolean isEven(int i) {
        return i % 2 == 0;
    }


}
