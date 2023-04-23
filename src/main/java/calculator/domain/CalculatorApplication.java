package calculator.domain;

import static calculator.view.InputView.clientResponse;
import static calculator.view.ResultView.printResult;

import java.util.Queue;

public class CalculatorApplication {

    private static final NumberCalculatorFactory NUMBER_CALCULATOR_FACTORY
            = new NumberCalculatorFactory();

    public static void main(String[] args) {
        progressCalculate();
    }

    public static void progressCalculate() {
        ClientResponse clientResponse = clientResponse();

        printResult(calculate(
                new Numbers(clientResponse.getNumbers()).numbers(),
                new Operators(clientResponse.getSymbols()).operators()));
    }

    public static Integer calculate(Queue<Integer> numbers, Queue<String> operators) {
        if(isSingle(numbers)) {
            return numbers.poll();
        }

        int result = NUMBER_CALCULATOR_FACTORY
                .getHandlerBySymbol(operators.poll())
                .calculateTwoNumbers(numbers.poll(),numbers.poll());

        while (!numbers.isEmpty()) {
            result = NUMBER_CALCULATOR_FACTORY
                    .getHandlerBySymbol(operators.poll())
                    .calculateTwoNumbers(result,numbers.poll());
        }

        return result;
    }

    private static boolean isSingle(Queue<Integer> numbers) {
        return numbers.size() == 1;
    }
}
