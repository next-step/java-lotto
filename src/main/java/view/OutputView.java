package view;

public class OutputView {

    private static final OutputView instance = new OutputView();

    private OutputView() {}

    public static OutputView getInstance() {
        return instance;
    }

    public void printCalculationResult(int result) {
        System.out.println("계산 결과 : " + result);
    }
}
