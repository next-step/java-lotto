package step1.view;

import step1.domain.Operand;
import step1.domain.Operator;
import step1.model.Operands;
import step1.model.Operators;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class InputView {
    private final Scanner scanner = new Scanner(System.in);
    private final String input;
    private Operators operators = Operators.getInstance();
    private Operands operands = Operands.getInstance();
    private static final String DELIMITER = " ";

    public InputView() {
        System.out.println("계산할 수식을 입력하세요.");
        this.input = scanner.nextLine();
        validateInput();
        splitTokens(Arrays.asList(input.split(DELIMITER)));

    }

    public String receiveInput() {
        return input;
    }

    private void validateInput() {
        if (this.input == null || this.input.isBlank()) {
            throw new IllegalArgumentException("null 또는 빈 공백은 입력할 수 없습니다.");
        }
    }

    private void splitTokens(List<String> tokens) {
        for (int i = 0; i < tokens.size(); i++) {
            if (isEven(i)) {
                Operand operand = new Operand(convertToInteger(tokens.get(i)));
                operands.addOperand(operand);
            }

            if (isOdd(i)) {
                operators.addOperator(Operator.getInstance(tokens.get(i)));
            }
        }
    }


    private Integer convertToInteger(String s) {
        try {
            return Integer.parseInt(s);
        } catch (Exception e) {
            throw new IllegalArgumentException("숫자로 변환할 수 없는 문자입니다.");
        }
    }

    private boolean isEven(int i) {
        return i % 2 == 0;
    }

    private boolean isOdd(int i) {
        return i % 2 == 1;
    }
}
