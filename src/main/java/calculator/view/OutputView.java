package calculator.view;

public class OutputView {

    private OutputView() {
        throw new AssertionError();
    }
    public static void printResult(int totalSum) {
        System.out.println(totalSum);
    }
}
