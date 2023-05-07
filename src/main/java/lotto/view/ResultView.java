package lotto.view;

public class ResultView {

    private static final String BUY_COMPLETED_INPUT_TEXT = "%s개를 구매했습니다.";

    public void printBuyCompleted(String count) {
        System.out.format(BUY_COMPLETED_INPUT_TEXT, count);
    }

}
