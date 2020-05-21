package stringcalculator.application;

import stringcalculator.domain.Calculator;
import stringcalculator.domain.Number;
import stringcalculator.ui.InputView;

import java.util.List;

public class CalculatorService {
    public int calculateSum(InputView inputView) {
        List<Number> numbers = inputView.extractNumbers();
        return Calculator.sum(numbers);
    }
}
