package lottery.domain.winningstrategy;

import lottery.domain.Lottery;
import lottery.domain.LotteryResult;

public interface WinningLotteryStrategy {

    LotteryResult getScore(Lottery lottery);
}
