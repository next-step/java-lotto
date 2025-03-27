package step2.domain;

import step2.domain.lotto.LottoContainer;
import step2.domain.lotto.LottoGenerator;

public class LottoCount {
    private final int count;

    public LottoCount(int purchaseAmount, int lottoPrice) {
        if (isValid(purchaseAmount, lottoPrice)) {
            String validationMessage = String.format("로또 구입 금액은 %d원 이상이어야 하며 %d원 단위로 가능합니다.",
                    lottoPrice, lottoPrice);
            throw new IllegalArgumentException(validationMessage);
        }
        this.count = purchaseAmount / lottoPrice;
    }

    public LottoContainer generateLottoContainer(LottoGenerator lottoGenerator) {
        return new LottoContainer(count, lottoGenerator);
    }

    private boolean isValid(int purchaseAmount, int lottoPrice) {
        return purchaseAmount < lottoPrice || purchaseAmount % lottoPrice != 0;
    }
}
