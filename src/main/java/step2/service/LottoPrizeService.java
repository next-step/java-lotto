package step2.service;

import step2.domain.LottoGame;
import step2.generator.Lotto45NumbersStrategy;

public class LottoPrizeService {

    public LottoGame startLottoGame(int tryNumbers) {
        return LottoGame.create(tryNumbers, new Lotto45NumbersStrategy());
    }
}
