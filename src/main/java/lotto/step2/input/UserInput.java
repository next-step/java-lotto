package lotto.step2.input;

import lotto.step2.domain.Lotto;
import lotto.step2.service.LottoProgram;

import java.util.List;

public class UserInput {
    private final PurchaseAmount purchaseAmount;
    private final PassiveLottoCount passiveLottoCount;
    private final List<Lotto> passiveLottos;

    public UserInput(final PurchaseAmount purchaseAmount, final PassiveLottoCount passiveLottoCount, final List<Lotto> passiveLottos) {
        this.purchaseAmount = purchaseAmount;
        this.passiveLottoCount = passiveLottoCount;
        this.passiveLottos = passiveLottos;
    }

    public int getPurchaseAmount() {
        return purchaseAmount.getValue();
    }

    public int getPassiveLottoCount() {
        return passiveLottoCount.getValue();
    }

    public List<Lotto> getPassiveLottos() {
        return passiveLottos;
    }

    public int getTotalLottosCount() {
        return getPurchaseAmount() / LottoProgram.LOTTO_PRICE;
    }

    public int getAutoLottoCount() {
        return getTotalLottosCount() - getPassiveLottoCount();
    }
}
