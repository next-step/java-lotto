package lottery.domain.winningstrategy;

import lottery.domain.Lottery;
import lottery.domain.LotteryResult;

public interface WinningLotteryStrategy {

    LotteryResult getLotteryResult(Lottery lottery);
}
