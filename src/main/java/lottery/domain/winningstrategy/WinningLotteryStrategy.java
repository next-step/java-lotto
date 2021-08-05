package lottery.domain.winningstrategy;

import lottery.domain.lottery.Lottery;
import lottery.domain.lottery.LotteryResult;

public interface WinningLotteryStrategy {

    LotteryResult getScore(Lottery lottery);
}
