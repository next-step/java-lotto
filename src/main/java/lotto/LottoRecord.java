package lotto;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class LottoRecord {
    private final List<LottoRank> lottoRecord;

    private int rewardAll = 0;
    private double profit = 0;

    public LottoRecord() {
        this.lottoRecord = Arrays.stream(LottoRank.values())
                .collect(Collectors.toList());
    }

    public void recordRank(LottoRank lottoRank) {
        lottoRecord.add(lottoRank);
        rewardAll += lottoRank.getWinReward();
    }

    public boolean isRecord(LottoRank lottoRank, int expected) {
        return Collections.frequency(lottoRecord, lottoRank) == expected;
    }

    public Map<LottoRank, Long> calculateReward() {
        return lottoRecord.stream()
                .filter(lottoRank -> !lottoRank.isMiss())
                .collect(Collectors.groupingBy(Function.identity(), LinkedHashMap::new, Collectors.counting()));
    }

    public void calculateProfit(int lottoCount) {
        if (rewardAll != 0) {
            profit = Math.floor((double) rewardAll / (lottoCount * LottoValidationUtils.LOTTO_COST) * 100) / 100;
        }
    }

    public boolean isProfit(double expected) {
        return profit == expected;
    }

    public double getProfit() {
        return profit;
    }
}
