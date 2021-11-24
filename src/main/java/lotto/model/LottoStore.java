package lotto.model;

public class LottoStore {

    private static final int LOTTO_PRICE = 1000;

    private LottoStore() {
    }

    public static Lotto ticket(int purchaseAmount) {
        int count = purchaseAmount / LOTTO_PRICE;
        return new Lotto(count);
    }

    public static LottoReport report(Lotto lotto, LottoWinner winner) {
        return new LottoReport(lotto, winner);
    }
}
