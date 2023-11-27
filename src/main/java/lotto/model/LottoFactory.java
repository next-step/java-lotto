package lotto.model;

import lotto.strategy.LottoStrategy;
import lotto.strategy.ManualLotto;
import lotto.strategy.RandomLotto;

import java.util.ArrayList;
import java.util.List;

import static lotto.model.Lotto.LOTTO_PRICE;

public class LottoFactory {
    private final PurchaseMoney purchaseMoney;

    public LottoFactory(long purchaseMoney, ManualCount manualCount) {
        this.purchaseMoney = new PurchaseMoney(purchaseMoney, manualCount);
    }

    public LottoFactory(long purchaseMoney) {
        this(purchaseMoney, new ManualCount(0));
    }

    public PurchasedLottos generateLottos(List<LottoNumbers> manualLottos) {
        List<Lotto> lottos = new ArrayList<>();
        for (LottoNumbers lottoNumbers : manualLottos) {
            lottos.add(new Lotto(generateNumbers(new ManualLotto(lottoNumbers))));
        }

        for (int i = 0; i < totalLottoCount() - purchaseMoney.manualCount(); i++) {
            lottos.add(new Lotto(generateNumbers(new RandomLotto())));
        }
        return new PurchasedLottos(lottos);
    }

    private LottoNumbers generateNumbers(LottoStrategy lottoStrategy){
        return lottoStrategy.generateSixNumber();
    }

    public int totalLottoCount() {
        return (int) (this.purchaseMoney.money() / LOTTO_PRICE);
    }

    public int autoLottoCount(){
        return this.purchaseMoney.autoCount();
    }

    public int manualLottoCount(){
        return this.purchaseMoney.manualCount();
    }
}
