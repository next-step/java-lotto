package calculator.domain;


import calculator.view.Input;
import calculator.view.Output;

import java.util.List;

public class StringCalculator {

    public void calculate() {
        Input input = new Input();
        input.expression();

        new Output().print(execute(input.getOperandList(), input.getOperatorList()));
    }

    private int execute(List<Integer> operandList, List<String> operatorList) {
        int result = operandList.get(0);

        for (int i = 0; i < operatorList.size(); i++) {
            result = Operator.from(operatorList.get(i)).execute(result, operandList.get(i + 1));
        }
        return result;
    }
}
