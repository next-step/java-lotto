package lottery.domain.creatingstrategy;

import lottery.domain.Lotteries;
import lottery.domain.Money;

public interface CreatingLotteryStrategy {

    Lotteries getLotteries(Money money);
}
