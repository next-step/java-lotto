package calculator;

import calculator.operator.Operator;
import java.util.List;

public class CalculatorService {

    public int start(List<String> inputs) {
        int result = Validator.validateInputIsNumber(inputs.get(0));
        for (int i = 1; i < inputs.size(); i += 2) {
            int nextInput = Validator.validateInputIsNumber(inputs.get(i + 1));
            Operator operator = OperationFactory.getOperator(inputs.get(i));
            result = operator.calculate(result, nextInput);
        }
        return result;
    }

}
