package step1;

import java.util.List;

public class Calculator {
    private final List<Integer> operandList;
    private final List<String> operatorList;

    public Calculator(List<Integer> operandList, List<String> operatorList) {
        this.operandList = operandList;
        this.operatorList = operatorList;
    }

    public int calculate() {
        Sum sum = new Sum(operandList.get(0));

        for (int i = 0; i < operatorList.size(); i++) {
            String operator = operatorList.get(i);
            int operand = operandList.get(i + 1);

            sum = new Sum(Operation.findBySign(operator).apply(sum.getSum(), operand));

        }

        return sum.getSum();
    }

}
