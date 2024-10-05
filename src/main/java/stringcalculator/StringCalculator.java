package stringcalculator;

import stringcalculator.util.StringUtil;
import stringcalculator.view.InputView;
import stringcalculator.view.ResultView;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.List;

public class StringCalculator {
    private final InputView inputView;
    private final ResultView resultView;

    public StringCalculator(InputView inputView, ResultView resultView) {
        this.inputView = inputView;
        this.resultView = resultView;
    }

    public int calculate(List<String> strings) {
        Deque<Integer> operands = new ArrayDeque<>();
        Deque<String> operators = new ArrayDeque<>();

        for (String string : strings) {
            try {
                int num = Integer.parseInt(string);
                operands.offer(num);
                if(!operators.isEmpty() && operands.size() >= 2) {
                    Integer pop1 = operands.poll();
                    Integer pop2 = operands.poll();
                    int compute = compute(operators.pop(), pop1, pop2);
                    operands.offer(compute);
                }
            } catch (NumberFormatException e) {
                operators.offer(string);

            }
        }

        return operands.pop();
    }

    public void run() {
        String inputsFromUser = inputView.getInputsFromUser();
        int calculate = calculate(StringUtil.splitAsList(inputsFromUser));
        System.out.println("calculate = " + calculate);
    }

    private int compute(String operator, int operand1, int operand2) {
        if (operator.equals("+")) {

            return operand1 + operand2;
        }
        if (operator.equals("-")) {

            return operand1 - operand2;
        }
        if (operator.equals("*")) {

            return operand1 * operand2;
        }
        if (operator.equals("/")) {
            return operand1 / operand2;
        }
        return 0;
    }
}
