package calculator.model;

import calculator.util.ExpressionExtractorUtil;
import calculator.view.InputView;
import calculator.view.OutputView;

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
        } catch (RuntimeException runtimeException) {
            outputView.printErrorMessage(runtimeException.getMessage());
        }
    }

    private Calculator generateCalculator(String expression) {
        List<Number> numbers = ExpressionExtractorUtil.extractNumbers(expression);
        List<Operator> operators = ExpressionExtractorUtil.extractOperators(expression);
        return new Calculator(numbers, operators);
    }

}
