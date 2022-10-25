package lottoGame;

import lottoGame.model.InputParameter;
import lottoGame.model.lotto.Lottery;
import lottoGame.model.strategy.ShuffleStrategy;

public class LottoGame { ;
    private final InputParameter inputParameter;;
    private static final Double TICKET_PRICE = 1_000.00;
    private final Lottery lottery = new Lottery();


    public LottoGame(InputParameter inputParameter) {
        this.inputParameter = inputParameter;
    }

    public Lottery start(ShuffleStrategy shuffleStrategy) {
        lottery.create(inputParameter.getAmount()/ TICKET_PRICE, shuffleStrategy);
        return lottery;
    }

}
