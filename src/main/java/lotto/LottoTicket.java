package lotto;

public class LottoTicket {
    private static final int PRICE = 1000;

    public static int countByAmount(int paidAmount) {
        if (paidAmount < PRICE) {
            throw new IllegalArgumentException("지불한 금액이 로또 금액보다 적습니다.");
        }
        return paidAmount / PRICE;
    }
}
