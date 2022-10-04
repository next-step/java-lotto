package calculator.domain;

import java.util.*;

public class Input {
    private final static Scanner SCANNER = new Scanner(System.in);
    private final static String SEPARATOR = " ";

    public List<String> inputExpression() {
        System.out.println("계산식을 입력해주세요.(숫자와 연산자 사이는 띄워쓰기(space)로 구분)");
        String expression = SCANNER.nextLine();

        if (expression.trim().contains(SEPARATOR)) {
            return Arrays.asList(expression.split(SEPARATOR));
        }
        throw new InputMismatchException("입력된 계산식이 올바르지 않습니다.");
    }
}
