package lotto.domain;

import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class LottoStatistics {
    private static final long ZERO = 0L;

    private final EarningRate earningRate;
    private final Map<LottoPrize, Long> prizeMap;

    public LottoStatistics(EarningRate earningRate, Map<LottoPrize, Long> prizeMap) {
        validate(earningRate, prizeMap);
        this.earningRate = earningRate;
        this.prizeMap = prizeMap;
    }

    private void validate(EarningRate earningRate, Map<LottoPrize, Long> prizeMap) {
        if (earningRate == null) {
            throw new IllegalArgumentException("earningRate는 null 일 수 없습니다.");
        }

        if (prizeMap == null) {
            throw new IllegalArgumentException("prizeMap은 null 일 수 업습니다.");
        }
    }

    public EarningRate getEarningRate() {
        return earningRate;
    }

    public long getPrizeCount(LottoPrize lottoPrize) {
        return prizeMap.getOrDefault(lottoPrize, ZERO);
    }

    public static LottoStatistics from(LottoPrizes lottoPrizes) {
        return new LottoStatistics(
                lottoPrizes.toEarningRate(),
                lottoPrizes.getLottoPrizes().stream()
                        .collect(Collectors.groupingBy(Function.identity(), Collectors.counting())));
    }
}
