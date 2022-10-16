package lottoGame;

import lottoGame.model.InputParameter;
import lottoGame.model.Lottery;
import lottoGame.model.factory.DefaultLottoFactory;
import lottoGame.model.factory.LottoFactory;

public class LottoGenerator {
    private final int lotteryNum;
    private final LottoFactory lottoFactory;

    public LottoGenerator(InputParameter inputParameter, LottoFactory lottoFactory) {
        this.lottoFactory = lottoFactory;
        this.lotteryNum = inputParameter.getLotteryNum();
    }

    public Lottery create() {
        return new Lottery(lottoFactory);
    }
}
