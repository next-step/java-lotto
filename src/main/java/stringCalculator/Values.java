package stringCalculator;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Values {

    Queue<String> operators = new LinkedList<>();
    Queue<Integer> operands = new LinkedList<>();

    public void addValues(String str) {
        try {
            addOperand(Integer.parseInt(str));
        } catch(Exception e) {
            Arrays.stream(Operator.values()).filter(v -> v.getValue().equals(str)).findFirst().orElseThrow(
                    () -> new IllegalArgumentException("사칙 연산만 입력 가능합니다.")
            );
            addOperator(str);
        }
    }

    private void addOperand(int value) {
        operands.add(value);
    }

    private void addOperator(String value) {
        operators.add(value);
    }

    public int pollOperand() {
        return operands.poll();
    }

    public String pollOperator() {
        return operators.poll();
    }



}
