package lottery.dto;

import lottery.domain.LotteryResult;

import java.math.BigDecimal;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class LotteryStatisticDto {

    private final List<LotteryResultDto> lotteryResultDtos;
    private final BigDecimal earningsRate;

    public LotteryStatisticDto(final List<LotteryResult> defaultLotteryResults, final Map<LotteryResult, Integer> lotteryResultMap, final BigDecimal earningsRate) {
        this.lotteryResultDtos = toLotteryResultDtoMap(defaultLotteryResults, lotteryResultMap);
        this.earningsRate = earningsRate;
    }

    private List<LotteryResultDto> toLotteryResultDtoMap(final List<LotteryResult> defaultLotteryResults, final Map<LotteryResult, Integer> lotteryResultMap) {
        setDefaultLotteryResults(defaultLotteryResults, lotteryResultMap);
        return lotteryResultMap.entrySet()
                .stream()
                .map(entry -> entry.getKey().toDto(entry.getValue()))
                .sorted(Comparator.comparing(LotteryResultDto::getCashPrize))
                .collect(Collectors.toList());
    }

    private void setDefaultLotteryResults(final List<LotteryResult> defaultLotteryResults, final Map<LotteryResult, Integer> lotteryResultMap) {
        defaultLotteryResults
                .forEach(lotteryResult -> lotteryResultMap.put(lotteryResult, lotteryResultMap.getOrDefault(lotteryResult, 0)));
    }

    public List<LotteryResultDto> getLotteryResultDtos() {
        return lotteryResultDtos;
    }

    public BigDecimal getEarningsRate() {
        return earningsRate;
    }
}
