package lotto.ui;

public class ResultView {
    private static final String COUNT_OF_PURCHASE_MESSAGE = "%s개를 구매했습니다.";

    private ResultView() {
    }

    public static void printCountOfLottos(int count) {
        System.out.println(String.format(COUNT_OF_PURCHASE_MESSAGE, count));
    }
}
