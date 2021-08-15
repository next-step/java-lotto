package lottery.domain;

import lottery.domain.winningstrategy.WinningLotteryStrategy;
import lottery.dto.LotteryDto;
import lottery.dto.LotteryStatisticDto;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.function.Function;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Lotteries {

    private static final String NON_NULL = "입력값은 null 일 수 없습니다";

    private final List<Lottery> lotteries;

    public Lotteries(final List<Lottery> lotteries) {
        validateLotteries(lotteries);
        this.lotteries = lotteries;
    }

    public Lotteries(final List<Lottery> manualLotteries, final List<Lottery> lotteries) {
        validateLotteries(manualLotteries);
        validateLotteries(lotteries);
        this.lotteries = Stream.of(manualLotteries, lotteries)
                .flatMap(Collection::stream)
                .collect(Collectors.toList());
    }

    public LotteryStatisticDto getLotteryStatisticDto(final WinningLotteryStrategy winningLotteryStrategy) {
        Map<LotteryResult, Integer> lotteryResultMap = getLotteryResultMap(winningLotteryStrategy);
        return winningLotteryStrategy.getLotteryStatisticDto(lotteryResultMap, getEarningsRate(lotteryResultMap));
    }

    public List<LotteryDto> getLotteriesDto() {
        return lotteries.stream()
                .map(Lottery::toDto)
                .collect(Collectors.toList());
    }

    private Map<LotteryResult, Integer> getLotteryResultMap(final WinningLotteryStrategy winningLotteryStrategy) {
        return lotteries.stream()
                .map(lottery -> lottery.getLotteryResult(winningLotteryStrategy))
                .filter(LotteryResult::notBlank)
                .collect(Collectors.groupingBy(Function.identity(), countLotteryResult()));
    }

    private Collector<LotteryResult, ?, Integer> countLotteryResult() {
        return Collectors.reducing(0, e -> 1, Integer::sum);
    }

    private BigDecimal getEarningsRate(Map<LotteryResult, Integer> lotteryResultMap) {
        return new BigDecimal(getTotalEarnings(lotteryResultMap))
                .divide(new BigDecimal(getTotalLotteriesPrice()), 4, RoundingMode.HALF_UP);
    }

    private long getTotalEarnings(final Map<LotteryResult, Integer> lotteryResultMap) {
        return lotteryResultMap.entrySet()
                .stream()
                .map(entry -> entry.getKey().getTotalCashPrize(entry.getValue()))
                .reduce(0L, Long::sum);
    }

    private long getTotalLotteriesPrice() {
        return Lottery.PRICE.multiply(lotteries.size());
    }

    private void validateLotteries(final List<Lottery> lotteries) {
        if (Objects.isNull(lotteries)) {
            throw new IllegalArgumentException(NON_NULL);
        }
    }
}
