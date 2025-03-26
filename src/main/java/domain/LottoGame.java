package domain;

import domain.lotto.LottoContainer;

public class LottoGame {
    private final LottoContainer lottoContainer;

    public LottoGame(int purchaseAmount, int lottoPrice) {
        if (isValid(purchaseAmount, lottoPrice)) {
            String validationMessage = String.format("로또 구입 금액은 %d원 이상이어야 하며 %d원 단위로 가능합니다.",
                    lottoPrice, lottoPrice);
            throw new IllegalArgumentException(validationMessage);
        }
        this.lottoContainer = new LottoContainer(purchaseAmount / lottoPrice);
    }

    public int getLottoCount() {
        return lottoContainer.size();
    }

    private boolean isValid(int purchaseAmount, int lottoPrice) {
        return purchaseAmount < lottoPrice || purchaseAmount % lottoPrice != 0;
    }
}
