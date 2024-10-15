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

    public void printNumberOfGames(int number) {
        System.out.println(number + "개를 구매했습니다.");
    }
}
