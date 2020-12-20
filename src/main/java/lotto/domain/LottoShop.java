package lotto.domain;

import java.util.List;

public class LottoShop {
    private static final int LOTTO_PRICE = 1000;
    public static final int ZERO = 0;
    private final Lottos lottos = new Lottos();
    private final int autoLottoCount;

    public LottoShop(int money, int manualLottoCount) {
        if (money < ZERO || money < manualLottoCount * LOTTO_PRICE) {
            throw new NotEnoughLottoPurchaseMoneyException("구매금액이 부족합니다.");
        }
        this.autoLottoCount = (money / LOTTO_PRICE) - manualLottoCount;
    }

    public Lottos getAutoLottos() {
        if (autoLottoCount <= ZERO) {
            throw new NotEnoughLottoPurchaseMoneyException("구매금액이 부족합니다.");
        }
        return lottos.generateAutoLottos(autoLottoCount);
    }

    public Lottos getManualLottos(List<Lotto> manualLottos) {
        return lottos.generateManualLottos(manualLottos);
    }
}

