import model.Calculator;
import model.CalculatorImpl;
import model.Operator;
import view.InputView;
import view.ResultView;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

public class StringCalculator {
    private Calculator calculator;

    public StringCalculator(Calculator calculator) {
        this.calculator = calculator;
    }

    public int run(String[] split){
        Queue<String> ops = new LinkedList<>();
        Stack<Integer> results = new Stack<>();
        Queue<Integer> nums = new LinkedList<>();

        init(split, ops, nums);

        while(!ops.isEmpty()){
            String op = ops.poll();
            getResult(results, nums, op);
        }

        int res = results.pop();
        return res;
    }

    private void init(String[] split, Queue<String> ops, Queue<Integer> nums) {
        for(String s : split){
            saveOperatorsAndNums(s, ops, nums);
        }
    }

    private void getResult(Stack<Integer> results, Queue<Integer> nums, String op) {
        if(results.isEmpty()){
            int num1 = nums.poll();
            int num2 = nums.poll();
            int result = this.calculator.calculate(num1, num2, op);
            results.push(result);
        }
        else{
            int num1 = results.pop();
            int num2 = nums.poll();
            int result = this.calculator.calculate(num1 ,num2, op);
            results.push(result);
        }
    }

    private void saveOperatorsAndNums(String s, Queue<String> ops, Queue<Integer> nums) {
        if(Operator.VALID_OPERATORS.contains(s)){
            ops.add(s);
        }
        else{
            nums.add(Integer.parseInt(s));
        }
    }

    public static void main(String[] args) {
        String[] split = InputView.splitByEmptyString(InputView.getInput());

        Calculator calculator = new CalculatorImpl(new Operator());
        StringCalculator stringCalculator = new StringCalculator(calculator);
        int result = stringCalculator.run(split);

        ResultView.printResult(result);
    }
}
