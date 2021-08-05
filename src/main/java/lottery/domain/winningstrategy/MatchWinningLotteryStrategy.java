package lottery.domain.winningstrategy;

import lottery.domain.lottery.Lottery;
import lottery.domain.lottery.LotteryResult;

import static lottery.domain.lottery.LotteryResult.getLotteryResult;

public class MatchWinningLotteryStrategy implements WinningLotteryStrategy {

    private final Lottery winningLottery;

    public MatchWinningLotteryStrategy(final Lottery winningLottery) {
        this.winningLottery = winningLottery;
    }

    @Override
    public LotteryResult getScore(final Lottery lottery) {
        return getLotteryResult(winningLottery.getMatchesCount(lottery));
    }

}
