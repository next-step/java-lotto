package service;

public class LottoSalesService {

    private static final long PRICE = 1000L;

    private LottoSalesService() {
    }

    public static int validateMoneyAndReturnTicketCount(long money) {
        if (money < PRICE) {
            throw new IllegalArgumentException(PRICE + "원 이상부터 로또 구매가 가능합니다.");
        }
        return (int)(money / PRICE);
    }
}
