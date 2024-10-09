package view;

public class ResultView {

    public static final int LOTTO_PRICE = 1000;

    private ResultView() {
    }

    private static ResultView INSTANCE = null;

    public static ResultView getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new ResultView();
        }
        return INSTANCE;
    }

    public void printLottoCount(int priceTotal) {
        System.out.println(priceTotal / LOTTO_PRICE + "개를 구매했습니다.");
    }
}
