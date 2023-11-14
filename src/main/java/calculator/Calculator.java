package calculator;

import static calculator.exception.CustomExceptionCode.*;

public class Calculator {

    private static String SPLITER = " ";

    private int currentResult; // 현재 계산 결과 값
    private int currentIdx; // 현재 읽고 있는 값의 인덱스
    private String[] formulas; // 계산식

    public Calculator() {
        reset();
    }

    private void reset() {
        currentResult = 0;
        currentIdx = 0;
        formulas = null;
    }

    public int cal(String input) {
        reset(); // 초기화

        isNullOrBlank(input); // null과 빈 값 체크
        formulas = input.split(SPLITER);

        // 첫 값 읽기
        currentResult = Integer.parseInt(formulas[currentIdx++]);


        while (currentIdx < formulas.length) {
            calculate();
        }

        return currentResult;
    }

    private void calculate() {
        try {
            String operator = formulas[currentIdx++];
            int nextValue = Integer.parseInt(formulas[currentIdx++]);
            currentResult = Operator.calculate(currentResult, nextValue, operator);
        } catch (ArrayIndexOutOfBoundsException e) {
            // 미완성 수식 - 피연산자 부재
            throw new IllegalArgumentException(INCOMPLETED_FORMULA.getMessage());
        } catch (Exception e) {
            
            // 기타 오류
            throw e;
        }

    }

    private void isNullOrBlank(String s) {
        if (s == null || s.isBlank()) {
            throw new IllegalArgumentException(NULL_OR_BLANK_INPUT.getMessage());
        }
    }
}
