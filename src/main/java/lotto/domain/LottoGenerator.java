package lotto.domain;

public class LottoGenerator {
    private static final int LOTTO_SIZE = 6;
    private static final int PRICE_MONEY_UNIT = 1000;

    private final Lottos lottos;

    public LottoGenerator(int purchasePrice) {
        int lottoCount = purchasePrice / LOTTO_SIZE;
        lottos = new Lottos(lottoCount);
    }
}
