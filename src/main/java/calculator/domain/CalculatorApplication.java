package calculator.domain;

import static calculator.view.InputView.clientResponse;

import java.util.Queue;

public class CalculatorApplication {

    public static void main(String[] args) {
        progressCalculate();
    }

    public static void progressCalculate() {
        ClientResponse clientResponse = clientResponse();
        startCalculate(new Numbers(clientResponse.getNumbers()).numbers(),
                new Operators(clientResponse.getSymbols()).operators());
    }

    public static void startCalculate(Queue<Integer> numbers, Queue<String> operators) {

    }


}
