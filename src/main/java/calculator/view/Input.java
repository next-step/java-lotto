package calculator.view;

import java.util.InputMismatchException;
import java.util.Scanner;

import static validator.InputValidator.*;

public class Input {
    private final static Scanner SCANNER = new Scanner(System.in);

    public String expression() {
        System.out.println("계산식을 입력해주세요.(숫자와 연산자 사이는 띄어쓰기(space)로 구분)");
        String expression = SCANNER.nextLine();

        if (containSeparator(expression) && isValidOperand(expression) && isValidOperator(expression)) {
            return expression;
        }
        throw new InputMismatchException("입력한 계산식이 올바르지 않습니다.");
    }
}
