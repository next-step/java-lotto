package lotto.view;

public class ErrorView {

    public static final String ERROR_PURCHASE_PRICE = "[ERROR] 0이 아닌 1000으로 나누어지는 값을 입력해주세요.";
    public static final String ERROR_WINNING_NUMBER = "[ERROR] 1, 2, 3, 4, 5, 6 형태에 알맞고 중복없이 1~45까지의 번호 6개를 입력해주세요.";
    public static final String ERROR_BONUS_BALL = "[ERROR] 1 - 45 까지의 번호 1개를 입력해주세요.";
    public static final String ERROR_MANUAL_LOTTO_NUMBER = "[ERROR] 1, 2, 3, 4, 5, 6 형태에 알맞고 중복없이 1~45까지의 번호 6개를 %d번 입력해주세요.";
    public static final String ERROR_MANUAL_TICKET_COUNT = "[ERROR] 티켓의 총액이 구입 금액을 초과합니다.";

    public void printErrorPurchasePrice() {
        System.out.println(ERROR_PURCHASE_PRICE);
    }

    public void printErrorBonusBall() {
        System.out.println(ERROR_BONUS_BALL);
    }

    public void printErrorWinningNumber() {
        System.out.println(ERROR_WINNING_NUMBER);
    }

    public void printErrorManualLottoNumber(int manualTicketCount) {
        System.out.println(String.format(
            ERROR_MANUAL_LOTTO_NUMBER,
            manualTicketCount
        ));
    }

    public void printErrorManualTicketCount() {
        System.out.println(ERROR_MANUAL_TICKET_COUNT);
    }
}
