package calculator.domain;

import calculator.validation.OperationValidator;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static calculator.validation.OperationValidator.*;

public class StringCalculator {

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

    private static boolean isOdd(int i) {
        return i % 2 == 1;
    }

    private static boolean isEven(int i) {
        return i % 2 == 0;
    }


    public int startOperation() {
        int result = numberList.get(0);
        for (int i = 0; i < operationList.size(); i++) {
            Operation operation = Operation.findOperationBySign(operationList.get(i));
            operation.calculate(result, numberList.get(i + 1));
        }
        return result;

    }



}
