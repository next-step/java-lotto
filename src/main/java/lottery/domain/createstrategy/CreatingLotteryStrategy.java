package lottery.domain.createstrategy;

import lottery.domain.Lottery;
import lottery.domain.Money;

import java.util.List;

public interface CreatingLotteryStrategy {

    List<Lottery> createLotteries(final Money money);
}
