package application;

import domain.Calculator;
import domain.Number;
import ui.InputView;

import java.util.List;

public class CalculatorService {
    public int calculateSum(InputView inputView) {
        List<Number> numbers = inputView.extractNumbers();
        return Calculator.sum(numbers);
    }
}
