package step1;

import java.util.ArrayList;
import java.util.List;

import static java.lang.Integer.parseInt;

public class Formula {

    private final String input;
    private List<Integer> operand = new ArrayList<>();
    private Operator operator;

    public Formula(String input) {
        this.input = input;
        this.checkNull();
        this.splitInput();
    }
    // * 입력 값이 null이거나 빈 공백 문자일 경우 IllegalArgumentException throw

    private void checkNull() {
        if (this.input == null || this.input.equals(" ")) {
            throw new IllegalArgumentException("빈 문자를 입력하셨습니다.");
        }
    }

    private void splitInput() {
        String[] string = this.input.split(" ");

        for (int i = 0; i < string.length; i++) {
            divideOperandAndOperator(string, i);
        }
    }

    private void divideOperandAndOperator(String[] string, int i) {
        if (i % 2 == 0) {
            this.operand.add(parseInt(string[i]));
        } else { //ㅡ* 사칙연산 기호가 아닌 경우 IllegalArgumentException throw
            operator.setOperators(string[i]);
        }
    }

    public List<Integer> getOperand() {
        return operand;
    }

    public Operator getOperator() {
        return operator;
    }

}
