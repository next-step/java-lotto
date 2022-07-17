package lotto.domain;

import lotto.interfaces.LotteryGame;

import java.util.List;

public abstract class AbstractLotteryGame implements LotteryGame {
    List<LotteryNumber> lotteries;

    AbstractLotteryGame() {
    }

    AbstractLotteryGame(List<LotteryNumber> lotteries) {
        this.lotteries = lotteries;
    }

    abstract void create();

    @Override
    public List<LotteryNumber> getLotteries() {
        return lotteries;
    }
}
