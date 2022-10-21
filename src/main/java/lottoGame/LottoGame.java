package lottoGame;

import lottoGame.model.InputParameter;
import lottoGame.model.lotto.Lottery;
import lottoGame.model.strategy.ShuffleStrategy;

import java.util.List;

public class LottoGame {
    private final InputParameter inputParameter;;
    private final Lottery lottery = new Lottery();


    public LottoGame(InputParameter inputParameter) {
        this.inputParameter = inputParameter;
    }

    public Lottery start(ShuffleStrategy shuffleStrategy) {
        lottery.create(inputParameter.getLotteryNum(), shuffleStrategy);
        return lottery;
    }

}
