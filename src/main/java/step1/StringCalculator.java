package step1;

import step1.enums.ExceptionMessage;

public class StringCalculator {

    private final static String PLUS = "+";
    private final static String MINUS = "-";
    private final static String MULTIPLE = "*";
    private final static String DIVISION = "/";

    private int result = 0;

    //계산을 시작한다.
    public int start(String str){
        String[] strArr = StringUtil.splitBlank(str);
        checkArrNullOrEmpty(strArr);
        return calculate(strArr);
    }

    //배열을 입력받아 계산을 한다.
    public int calculate(String[] strArr) {
        result = StringUtil.toInt(strArr[0]);
        for (int i = 1; i < strArr.length; i += 2) {
            String operator = strArr[i];
            int num = StringUtil.toInt(strArr[i + 1]);
            checkSymbolAndCalculate(operator, num);
        }
        return result;
    }

    //더하기
    public int plus(int num1, int num2) {
        return num1 + num2;
    }

    //뺄셈
    public int minus(int num1, int num2) {
        return num1 - num2;
    }

    //곱하기
    public int multiple(int num1, int num2) {
        return num1 * num2;
    }

    //나눗셈
    public int division(int num1, int num2) {
        return num1 / num2;
    }

    //사직연산을 한다.
    private void checkSymbolAndCalculate(String operator, int num) {
        switch (operator) {
            case PLUS:
                result = plus(result, num);
                break;
            case MINUS:
                result = minus(result, num);
                break;
            case MULTIPLE:
                result = multiple(result, num);
                break;
            case DIVISION:
                result = division(result, num);
                break;
            default:
                throw new IllegalArgumentException(ExceptionMessage.SYMBOL_EXCEPTION.message());
        }
    }

    //배열에 빈값 혹은 null이 있는지 확인한다.
    private void checkArrNullOrEmpty(String[] strArr) {
        for(String str : strArr) {
            checkNullOrEmpty(str);
        }
    }

    //null이나 빈값일시 예외를 발생시킨다.
    private void checkNullOrEmpty(String str) {
        if(str == null || str.isEmpty()) {
            throw new IllegalArgumentException(ExceptionMessage.NULL_EMPTY_EXCEPTION.message());
        }
    }
}
