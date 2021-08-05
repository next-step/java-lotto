package lottery.domain.creatingstrategy;

import lottery.domain.lottery.Lotteries;

public interface CreatingLotteryStrategy {

    Lotteries getLotteries(int money);
}
