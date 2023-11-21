package lotto.view;

import lotto.domain.lotto.Lotto;
import lotto.domain.lotto.LottoNumber;
import lotto.domain.lotto.Lottos;
import lotto.domain.lotto.strategy.RandomStrategy;
import lotto.domain.summary.Summary;

import static lotto.domain.lotto.Lottos.PRICE_PER_TICKET;

public class UserInput {
    private final int purchasePrice;
    private final int manualLottoCount;

    private final InputView inputView;

    public UserInput(InputView inputView) {
        this.inputView = inputView;
        this.purchasePrice = inputView.readPurchasePrice();
        this.manualLottoCount = inputView.readManulLottoCount();

        Lottos.validate(purchasePrice, manualLottoCount);
    }

    public Lottos manualLottos() {
        return Lottos.of(purchasePrice(), inputView.readManualLotto(manualLottoCount));
    }

    private int purchasePrice() {
        return purchasePrice;
    }

    public Lottos autoLottos() {
        return Lottos.of(remainingPurchasePrice(), new RandomStrategy());
    }

    private int remainingPurchasePrice() {
        return purchasePrice - manualLottoCount * PRICE_PER_TICKET;
    }

    public Summary summary(Lottos lottos) {
        return lottos.match(jackpotLotto(), bonusNumber());
    }

    private Lotto jackpotLotto() {
        return Lotto.of(inputView.readJackpotNumber());
    }

    private LottoNumber bonusNumber() {
        return LottoNumber.of(inputView.readBonusNumber());
    }
}
