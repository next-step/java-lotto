package step2.service;

import step2.domain.LottoGame;
import step2.domain.LottoWinGenerator;
import step2.generator.Lotto45NumbersMakeStrategy;

public class LottoPrizeService {

    public LottoGame startLottoGame(int tryNumbers) {
        return LottoGame.create(tryNumbers
                , new Lotto45NumbersMakeStrategy()
                , new LottoWinGenerator()
        );
    }
}
