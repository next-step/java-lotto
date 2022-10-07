package stringcalculator;

import java.util.ArrayList;
import java.util.List;

public class Formula {
    private List<Integer> nums = new ArrayList<>();
    private List<String> operators = new ArrayList<>();

    public Formula() {
    }

    public Formula(List<Integer> nums, List<String> operators) {
        this.nums = nums;
        this.operators = operators;
    }

    public void addNumber(int num) {
        nums.add(num);
    }

    public void addOperator(String operator) {
        operators.add(operator);
    }

    public int calculate() {
        int result = nums.get(0);
        for (int i = 1; i < nums.size(); i++) {
            int num = nums.get(i);
            String operator = operators.get(i - 1);
            Operator oper = Operator.findOperator(operator);
            result = oper.calc(result, num);
        }
        return result;
    }

    @Override
    public String toString() {
        return "Formula{" +
                "nums=" + nums +
                ", operators=" + operators +
                '}';
    }
}
