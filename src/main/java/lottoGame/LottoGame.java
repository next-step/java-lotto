package lottoGame;

import lottoGame.model.InputParameter;
import lottoGame.model.lotto.Lottery;
import lottoGame.model.strategy.ShuffleStrategy;

import java.util.List;

public class LottoGame {
    private static final int TICKET_PRICE = 1000;
    private final InputParameter inputParameter;;
    private final Lottery lottery = new Lottery();


    public LottoGame(InputParameter inputParameter) {
        this.inputParameter = inputParameter;
    }

    public Lottery start(ShuffleStrategy shuffleStrategy) {
        lottery.create(inputParameter.getAmount()/ TICKET_PRICE, shuffleStrategy);
        return lottery;
    }

}
