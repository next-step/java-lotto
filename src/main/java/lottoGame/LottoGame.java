package lottoGame;

import lottoGame.model.InputParameter;
import lottoGame.model.TicketPrice;
import lottoGame.model.lotto.Lottery;
import lottoGame.model.strategy.ShuffleStrategy;

public class LottoGame { ;
    private final InputParameter inputParameter;;
    private final Lottery lottery = new Lottery();


    public LottoGame(InputParameter inputParameter) {
        this.inputParameter = inputParameter;
    }

    public Lottery start(ShuffleStrategy shuffleStrategy) {
        lottery.create(inputParameter.getAmount()/ TicketPrice.TICKET_PRICE, shuffleStrategy);
        return lottery;
    }

}
