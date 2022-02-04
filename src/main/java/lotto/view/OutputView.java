package lotto.view;

public class OutputView {

    public static final String ERROR_MESSAGE = "[ERROR] ";
    public static final String ERROR_WRONG_LOTTO_PRICE = "로또 한 장은 1000원입니다. 잘못된 금액입니다.";
    private static final String REQUEST_LOTTO_PRICE = "구입금액을 입력해 주세요.";
    private static final String SYSTEM_LOTTO_COUNT = "개를 구매했습니다.";
    private static final String REQUEST_WINNING_NUMBER_BEFORE = "지난 주 당첨 번호를 입력해주세요.(ex 1, 2, 3, 4, 5)";
    private static final String REQUEST_BONUS_BALL_NUMBER = "보너스 볼을 입력해주세요.";

    public static void printExceptionMessage(String exceptionMessage) {
        System.out.println(ERROR_MESSAGE + exceptionMessage);
    }

    public static void printRequestLottoPrice() {
        System.out.println(REQUEST_LOTTO_PRICE);
    }

    public static void printLottoCount(int count) {
        System.out.println(count + SYSTEM_LOTTO_COUNT);
    }

    public static void printWinningNumberBefore() {
        System.out.println(REQUEST_WINNING_NUMBER_BEFORE);
    }

    public static void printBonusBallNumber() {
        System.out.println(REQUEST_BONUS_BALL_NUMBER);
    }
}
