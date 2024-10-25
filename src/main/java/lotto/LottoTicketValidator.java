package lotto;

public class LottoTicketValidator {
    private static final int PRICE = 1000;

    public static int countByAmount(int paidAmount) {
        if (paidAmount < PRICE) {
            throw new IllegalArgumentException("지불한 금액이 로또 금액보다 적습니다.");
        }
        return paidAmount / PRICE;
    }

    public static void checkManualLottoCount(int totalLottoCount, int manualLottoCount) {
        if (totalLottoCount < manualLottoCount) {
            throw new IllegalArgumentException("구매할 수 있는 로또 수보다 수동으로 구매할 로또의 수가 더 많습니다.");
        }
    }
}
