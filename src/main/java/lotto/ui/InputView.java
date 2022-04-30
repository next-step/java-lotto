package lotto.ui;

public class InputView {
    private static final String INPUT_PRICE_MESSAGE = "구입금액을 입력해 주세요.";
    private static final String LAST_WINNING_MESSAGE = "지난 주 당첨 번호를 입력해 주세요.";
    private static final String INPUT_LAST_WINNING_MESSAGE1 = LAST_WINNING_MESSAGE;

    public static String getPrice() {
        System.out.println(INPUT_PRICE_MESSAGE);
        return Console.readLine();
    }

    public static String getLastWinningNumber() {
        System.out.println(INPUT_LAST_WINNING_MESSAGE1);
        return Console.readLine();
    }

}
