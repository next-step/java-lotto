package lotto.domain;

public class Calculator {

    final static int LOTTO_TICKET_PRICE = 1000;

    public static int calculateLottoTicketCount(int payment) {
        validatePayment(payment);
        return payment/ LOTTO_TICKET_PRICE;
    }

    private static void validatePayment(int payment) {
        if (Integer.compare(payment, LOTTO_TICKET_PRICE) == -1)
            throw new IllegalArgumentException("구입 금액은 로또 금액보다 커야 합니다.");
    }

    public static int getAutoLottoCount(int lottoCount, int manualLottoCount) {
        validateManualLottoCount(manualLottoCount);
        int autoLottoCount = lottoCount - manualLottoCount;
        validateLottoCount(autoLottoCount);
        return autoLottoCount;
    }

    private static void validateManualLottoCount(int manualLottoCount) {
        if (manualLottoCount < 0) {
            throw new IllegalArgumentException("구매 수량은 0 이상이어야 합니다.");
        }
    }

    private static void validateLottoCount(int autoLottoCount) {
        if (autoLottoCount < 0) {
            throw new IllegalArgumentException("구입 금액으로 구매할 수 없는 수량입니다.");
        }
    }
}
