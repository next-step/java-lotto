package calculator.domain;

import static calculator.view.InputView.clientResponse;
import static calculator.view.ResultView.printResult;

import java.util.Queue;

public class CalculatorApplication {

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
        int result = 0;

        return 0;
    }


}
