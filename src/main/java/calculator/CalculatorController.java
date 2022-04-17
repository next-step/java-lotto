package calculator;

import java.util.List;

public class CalculatorController {

    private final InputView inputView;

    private final OutputView outputView;

    public CalculatorController() {
        this(new InputView(), new OutputView());
    }

    public CalculatorController(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public void start() {
        try {
            Calculator calculator = generateCalculator(inputView.readExpression());
            Number resultNumber = calculator.calculate();
            outputView.printResult(resultNumber);
        } catch (Exception exception) {
            outputView.printErrorMessage(exception.getMessage());
        }
    }

    private Calculator generateCalculator(String expression) {
        List<Number> numbers = ExpressionExtractor.extractNumbers(expression);
        List<Operator> operators = ExpressionExtractor.extractOperators(expression);
        return new Calculator(numbers, operators);
    }

}
