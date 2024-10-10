import model.Calculator;
import model.CalculatorImpl;
import model.Operator;
import view.InputView;
import view.ResultView;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
import java.util.stream.Collectors;

public class StringCalculator {
    private Calculator calculator;

    public StringCalculator(Calculator calculator) {
        this.calculator = calculator;
    }

    public int run(String[] split) {
        Queue<String> ops = getOps(split);
        Queue<Integer> nums = getNums(split);
        Stack<Integer> results = new Stack<>();

        while (!ops.isEmpty()) {
            String op = ops.poll();
            Integer result = getResult(results, nums, op);
            if (result != null) {
                results.push(result);
            }
        }

        return results.pop();
    }

    private Queue<Integer> getNums(String[] split) {
        Queue<Integer> queue = Arrays.stream(split)
                .filter(it -> it.matches("\\d"))
                .map(Integer::parseInt)
                .collect(Collectors.toCollection(LinkedList::new));
        return queue;
    }

    private Queue<String> getOps(String[] split) {
        Queue<String> queue = Arrays.stream(split)
                .filter(it -> Operator.VALID_OPERATORS.contains(it))
                .collect(Collectors.toCollection(LinkedList::new));
        return queue;
    }


    private Integer getResult(Stack<Integer> results, Queue<Integer> nums, String op) {
        Integer result;
        Integer num1;
        Integer num2;
        if (results.isEmpty()) {
            num1 = nums.poll();
            num2 = nums.poll();
            result = this.calculator.calculate(num1, num2, op);
            return result;
        }
        num1 = results.pop();
        num2 = nums.poll();
        result = this.calculator.calculate(num1, num2, op);
        return result;
    }


    public static void main(String[] args) {
        String[] split = InputView.splitByEmptyString(InputView.getInput());

        Calculator calculator = new CalculatorImpl();
        StringCalculator stringCalculator = new StringCalculator(calculator);
        int result = stringCalculator.run(split);

        ResultView.printResult(result);
    }
}
