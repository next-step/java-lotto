package lottoGame;

import lottoGame.dto.ResultParameter;
import lottoGame.model.lotto.Lottery;
import lottoGame.model.lotto.WinningLotto;
import lottoGame.model.strategy.ShuffleStrategy;

public class LottoGame {
    public static final Double TICKET_PRICE = 1_000.00;
    private final Lottery lottery = new Lottery();

    public Lottery createLotto(Double amount, ShuffleStrategy shuffleStrategy) {
        lottery.create(amount / TICKET_PRICE, shuffleStrategy);
        return lottery;
    }

    public ResultParameter getResult() {
        return new ResultParameter(lottery.getLottery());
    }

    public RankResult fillInRankResult(WinningLotto winningLotto, RankResult rankResult) {
        return lottery.fillRankResult(winningLotto, rankResult);
    }

}
