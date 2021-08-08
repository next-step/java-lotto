package lottery.dto;

import lottery.domain.LotteryResult;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class LotteryStatisticDto {

    private final List<LotteryResultDto> lotteryResultDtos;
    private final double earningsRate;

    public LotteryStatisticDto(final Map<LotteryResult, Integer> lotteryResultMap, final BigDecimal earningsRate) {
        this.lotteryResultDtos = toLotteryResultDtoMap(lotteryResultMap);
        this.earningsRate = earningsRate;
    }

    private List<LotteryResultDto> toLotteryResultDtoMap(final Map<LotteryResult, Integer> lotteryResultMap) {
        Map<LotteryResult, Integer> defaultLotteryResultMap = getDefaultLotteryResultMap();
        defaultLotteryResultMap.putAll(lotteryResultMap);
        return defaultLotteryResultMap.entrySet()
                .stream()
                .map(entry -> entry.getKey().toDto(entry.getValue()))
                .sorted(Comparator.comparing(LotteryResultDto::getCashPrize))
                .collect(Collectors.toList());
    }

    private Map<LotteryResult, Integer> getDefaultLotteryResultMap() {
        return Stream.of(
                LotteryResult.THREE_MATCHES,
                LotteryResult.FOUR_MATCHES,
                LotteryResult.FIVE_MATCHES,
                LotteryResult.SIX_MATCHES)
                .collect(Collectors.toMap(Function.identity(), v -> 0));
    }

    public List<LotteryResultDto> getLotteryResultDtos() {
        return lotteryResultDtos;
    }

    public double getEarningsRate() {
        return earningsRate;
    }
}
