package calculator.view;

public class CalculatorResultView {

    private CalculatorResultView() {

    }

    public static void printResult(int result) {
        System.out.printf("연산 결과: %d", result);
    }
}
