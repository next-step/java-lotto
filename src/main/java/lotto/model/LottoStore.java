package lotto.model;

public class LottoStore {

    private static final int LOTTO_PRICE = 1000;

    private LottoStore() {
    }

    public static Lotto ticket(int purchaseAmount) {
        return new Lotto(purchaseAmount / LOTTO_PRICE);
    }

    public static void match(Lotto lotto, LottoWinner winner) {
        for (LottoNumbers lottoNumbers : lotto.getLotto()) {
            winner.match(lottoNumbers);
        }
    }

}
