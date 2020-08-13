package view;

public class ResultView {
    public static final String BUY_AMOUNT_MESSAGE = "개를 구매했습니다.";

    public static void viewBuyAmount(int buyAmount) {
        System.out.println(buyAmount + BUY_AMOUNT_MESSAGE);
    }
}
