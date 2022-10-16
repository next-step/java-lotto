package lottoGame;

import lottoGame.model.InputParameter;
import lottoGame.model.Lottery;
import lottoGame.model.factory.DefaultLottoFactory;

public class LottoGenerator {
    private final int lotteryNum;

    public LottoGenerator(InputParameter inputParameter) {
        this.lotteryNum = inputParameter.getLotteryNum();
    }

    public Lottery create() {

        return new Lottery(lotteryNum, new DefaultLottoFactory());
    }
}
