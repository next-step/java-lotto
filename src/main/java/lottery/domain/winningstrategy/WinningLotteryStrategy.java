package lottery.domain.winningstrategy;

import lottery.domain.Lottery;
import lottery.domain.LotteryResult;
import lottery.dto.LotteryStatisticDto;

import java.math.BigDecimal;
import java.util.Map;

public interface WinningLotteryStrategy {

    LotteryResult getLotteryResult(final Lottery lottery);

    LotteryStatisticDto getLotteryStatisticDto(final Map<LotteryResult, Integer> lotteryResultMap, final BigDecimal earningsRate);
}
