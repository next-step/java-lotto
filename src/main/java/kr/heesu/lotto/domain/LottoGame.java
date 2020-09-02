package kr.heesu.lotto.domain;

import kr.heesu.lotto.utils.LottoFactory;

import java.util.Set;

public class LottoGame {
    private final Lottos lottos;
    private final PurchaseAmount purchaseAmount;

    private LottoGame(Lottos lottos, PurchaseAmount purchaseAmount) {
        this.lottos = lottos;
        this.purchaseAmount = purchaseAmount;
    }

    public static LottoGame of(PurchaseAmount purchaseAmount, String manualLottoInput) {
        Set<Lotto> manualLottos = LottoFactory.createManualLottoSet(manualLottoInput);
        Set<Lotto> autoLottos = LottoFactory.createAutoLottoSet(purchaseAmount.getSize() - manualLottos.size());
        manualLottos.addAll(autoLottos);

        if (purchaseAmount.getSize() != manualLottos.size()) {
            throw new IllegalArgumentException();
        }
        return new LottoGame(Lottos.of(manualLottos), purchaseAmount);
    }

    public LottoStatistics matches(WinningLotto winningLotto) {
        return LottoStatistics.of(
                lottos.matches(winningLotto),
                purchaseAmount
        );
    }

    @Override
    public String toString() {
        return lottos.toString();
    }
}
