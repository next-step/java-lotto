package calculator.string;

import calculator.string.domain.CalculatorSymbol;
import calculator.string.domain.Number;
import calculator.string.view.InputView;
import calculator.string.view.OutputView;

import java.util.List;

public class Main {

    public static void main(String[] args) {
        InputView inputView = new InputView();
        OutputView outputView = new OutputView();
        CalculateHandler handler = new CalculateHandler();

        String inputValue = inputView.inputView();
        String[] splitStrings = handler.split(inputValue);
        List<Number> numbers = handler.sectionNumber(splitStrings);
        List<CalculatorSymbol> calculatorSigns = handler.sectionCalculate(splitStrings);
        int result = handler.calculate(numbers, calculatorSigns);

        outputView.print(result);
    }
}
