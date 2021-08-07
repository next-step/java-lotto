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

    public LotteryStatisticDto(final Map<LotteryResult, Long> lotteryResultMap, final double earningsRate) {
        this.lotteryResultDtos = toLotteryResultDtoMap(lotteryResultMap);
        this.earningsRate = earningsRate;
    }

    private List<LotteryResultDto> toLotteryResultDtoMap(final Map<LotteryResult, Long> lotteryResultMap) {
        Map<LotteryResult, Long> defaultLotteryResultMap = getDefaultLotteryResultMap();
        defaultLotteryResultMap.putAll(lotteryResultMap);
        return defaultLotteryResultMap.entrySet()
                .stream()
                .map(entry -> entry.getKey().toDto(entry.getValue()))
                .sorted(Comparator.comparing(LotteryResultDto::getCashPrize))
                .collect(Collectors.toList());
    }

    private Map<LotteryResult, Long> getDefaultLotteryResultMap() {
        return Stream.of(
                LotteryResult.THREE_MATCHES,
                LotteryResult.FOUR_MATCHES,
                LotteryResult.FIVE_MATCHES,
                LotteryResult.SIX_MATCHES)
                .collect(Collectors.toMap(Function.identity(), v -> 0L));
    }

    public List<LotteryResultDto> getLotteryResultDtos() {
        return lotteryResultDtos;
    }

    public double getEarningsRate() {
        return earningsRate;
    }
}
