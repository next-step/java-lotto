package lotto.domain;

import java.util.List;

public class LottoGenerator {
    private static final int PRICE_MONEY_UNIT = 1000;
    private static final String INCORRECT_UNIT_ERROR_MESSAGE = "구입금액은 1000원 단위입니다.";

    private final Lottos lottos;

    public LottoGenerator(final int purchasePrice) {
        validatePurchasePrice(purchasePrice);
        int lottoCount = purchasePrice / PRICE_MONEY_UNIT;
        this.lottos = new Lottos(lottoCount);
    }

    private void validatePurchasePrice(final int purchasePrice) {
        if (purchasePrice % PRICE_MONEY_UNIT != 0) {
            throw new IllegalArgumentException(INCORRECT_UNIT_ERROR_MESSAGE);
        }
    }

    public LottoResult calculateWinningLotto(WinningLotto winningLotto) {
        List<LottoReward> lottoRewards = lottos.calculateRewards(winningLotto);
        return new LottoResult(lottoRewards);
    }

    public Lottos getLottos() {
        return lottos;
    }
}
