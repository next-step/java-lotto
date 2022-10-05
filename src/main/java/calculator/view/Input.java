package calculator.view;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static calculator.validate.InputValidator.*;

public class Input {
    private final static Scanner SCANNER = new Scanner(System.in);
    private final static String SEPARATOR = " ";

    private List<Integer> operandList;
    private List<String> operatorList;

    public void expression() {
        System.out.println("계산식을 입력해주세요.(숫자와 연산자 사이는 띄어쓰기(space)로 구분)");
        String expression = SCANNER.nextLine();

        if (containSeparator(expression) && isValidOperand(expression) && isValidOperator(expression)) {
            List<String> elementsOfExpression = Arrays.asList(expression.split(SEPARATOR));
            parseOperand(elementsOfExpression);
            parseOperator(elementsOfExpression);
        }
    }

    private void parseOperand(List<String> elementsOfExpression) {
        operandList = IntStream.range(0, elementsOfExpression.size())
                .filter(i -> i % 2 == 0)
                .mapToObj(i -> Integer.parseInt(elementsOfExpression.get(i)))
                .collect(Collectors.toList());
    }

    private void parseOperator(List<String> elementsOfExpression) {
        operatorList = IntStream.range(0, elementsOfExpression.size())
                .filter(i -> i % 2 == 1)
                .mapToObj(i -> elementsOfExpression.get(i))
                .collect(Collectors.toList());
    }

    public List<Integer> getOperandList() {
        return Collections.unmodifiableList(operandList);
    }

    public List<String> getOperatorList() {
        return Collections.unmodifiableList(operatorList);
    }
}
