package lotto.service;

import lotto.domain.LottoGame;
import lotto.domain.Money;
import lotto.generator.Lotto45NumbersMakeStrategy;

public class LottoPrizeService {

    public LottoGame startLottoGame(Money tryMoney) {
        return LottoGame.create(tryMoney, new Lotto45NumbersMakeStrategy());
    }
}
