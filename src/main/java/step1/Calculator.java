package step1;

import java.util.ArrayList;
import java.util.Objects;

import static java.lang.Integer.parseInt;


public class Calculator {

    private static final String DELIMITER = " ";
    private final ArrayList<String> operator = new ArrayList<>();
    private final ArrayList<Integer> operand = new ArrayList<>();

    private int answer;

    public Calculator(String input) {
        checkNull(input);
        splitInput(input);
    }

    private void checkNull(String input) {
        if (input == null || input.equals(" ")) {
            throw new IllegalArgumentException("빈 문자를 입력하셨습니다.");
        }
    }

    public void init() {
        answer = operand.get(0);
    }

    private void splitInput(String input) {
        String[] strings = input.split(DELIMITER);

        for (int i = 0; i < strings.length; i++) {
            addOperand(i, strings[i]);
            addOperators(i, strings[i]);
        }
    }

    private void addOperand(int i, String operand) {
        if (i % 2 == 0) {
            this.operand.add(parseInt(operand));
        }
    }

    private void addOperators(int i, String operator) {
        if (i % 2 == 1) {
            validOperator(operator);
            this.operator.add(operator);
        }
    }

    private void validOperator(String target) {
        if (!target.matches("^[*/+-]+$")) {
            throw new IllegalArgumentException("사칙연산 기호만 사용해주세요.");
        }
    }

    public int execute() {

        for (int i = 0; i < this.operator.size(); i++) {
            calculate(this.operator.get(i), this.operand.get(i + 1));
        }

        return answer;
    }

    private void calculate(String operator, int withOperand) {

        if (Objects.equals(operator, "*")) {
            multiply(withOperand);
        }
        if (Objects.equals(operator, "/")) {
            divide(withOperand);
        }
        if (Objects.equals(operator, "-")) {
            minus(withOperand);
        }
        if (Objects.equals(operator, "+")) {
            plus(withOperand);
        }
    }

    private void multiply(int withOperand) {
        answer *= withOperand;
    }

    private void divide(int withOperand) {
        answer /= withOperand;
    }

    private void minus(int withOperand) {
        answer -= withOperand;
    }

    private void plus(int withOperand) {
        answer += withOperand;
    }

    public void printResult() {
        ResultView.printResult(this.answer);
    }
}