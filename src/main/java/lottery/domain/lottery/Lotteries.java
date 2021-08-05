package lottery.domain.lottery;

import lottery.domain.winningstrategy.WinningLotteryStrategy;
import lottery.dto.LotteryDto;
import lottery.dto.LotteryStatisticDto;

import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Lotteries {

    public static final String NON_NULL = "입력값은 null 일 수 없습니다";

    private final List<Lottery> lotteries;

    public Lotteries(final List<Lottery> lotteries) {
        validateLotteries(lotteries);
        this.lotteries = lotteries;
    }

    public LotteryStatisticDto getLotteryStatisticDto(final WinningLotteryStrategy winningLotteryStrategy) {
        Map<LotteryResult, Long> lotteryResultMap = getLotteryResultMap(winningLotteryStrategy);
        return new LotteryStatisticDto(lotteryResultMap, getEarningsRate(lotteryResultMap));
    }

    public List<LotteryDto> getLotteriesDto() {
        return lotteries.stream()
                .map(Lottery::toDto)
                .collect(Collectors.toList());
    }

    private Map<LotteryResult, Long> getLotteryResultMap(final WinningLotteryStrategy winningLotteryStrategy) {
        return lotteries.stream()
                .map(lottery -> lottery.getLotteryResult(winningLotteryStrategy))
                .filter(LotteryResult::notBlank)
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
    }

    private double getEarningsRate(Map<LotteryResult, Long> lotteryResultMap) {
        return (double) getTotalEarnings(lotteryResultMap) / getTotalLotteriesPrice();
    }

    private long getTotalEarnings(final Map<LotteryResult, Long> lotteryResultMap) {
        return lotteryResultMap.entrySet()
                .stream()
                .map(entry -> entry.getKey().getTotalCashPrize(entry.getValue()))
                .reduce(0L, Long::sum);
    }

    private long getTotalLotteriesPrice() {
        return (long) lotteries.size() * Lottery.PRICE;
    }

    private void validateLotteries(final List<Lottery> lotteries) {
        if (Objects.isNull(lotteries)) {
            throw new IllegalArgumentException(NON_NULL);
        }
    }
}
