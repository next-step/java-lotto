package lotto.domain;

public class LottoShop {
    private static final int LOTTO_PRICE = 1000;

    public static Lottos purchaseTicket(int money) {
        if (money % 1000 != 0) {
            throw new IllegalArgumentException("구매 금액은 1000 단위로 입력해야 합니다.");
        }
        return LottoGenerator.lotteryTickets(countPurchase(money));
    }

    public static int countPurchase(int money) {
        return money / LOTTO_PRICE;
    }
}
