package step2.service;

import step2.domain.LottoGame;
import step2.domain.Money;
import step2.generator.Lotto45NumbersMakeStrategy;

public class LottoPrizeService {

    public LottoGame startLottoGame(Money tryMoney) {
        return LottoGame.create(tryMoney, new Lotto45NumbersMakeStrategy());
    }
}
