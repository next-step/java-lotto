package lottoGame;

import lottoGame.model.InputParameter;
import lottoGame.model.lotto.Lottery;
import lottoGame.model.strategy.ShuffleStrategy;

import java.util.List;

public class LottoGame {
    private final InputParameter inputParameter;
    private final ShuffleStrategy shuffleStrategy;
    ;

    private final Lottery lottery = new Lottery();


    public LottoGame(InputParameter inputParameter, ShuffleStrategy shuffleStrategy) {
        this.inputParameter = inputParameter;
        this.shuffleStrategy = shuffleStrategy;
    }

    public Lottery start() {
        lottery.create(inputParameter.getLotteryNum(), shuffleStrategy);
        return lottery;
    }

}
