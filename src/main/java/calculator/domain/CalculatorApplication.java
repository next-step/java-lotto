package calculator.domain;

import static calculator.view.InputView.clientResponse;

public class CalculatorApplication {

    public static void main(String[] args) {
        startCalculator();
    }

    public static void startCalculator() {
        ClientResponse clientResponse = clientResponse();
    }
}
