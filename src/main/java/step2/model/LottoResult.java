package step2.model;

import java.util.Arrays;
import java.util.Map;
import java.util.stream.Collectors;

public class LottoResult {

    private static final int EACH_LOTTO_PRICE = 1000;

    private final Map<LottoRank, Long> lottoRanks;

    public LottoResult(Map<LottoRank, Long> lottoRanks) {
        Map<LottoRank, Long> initialLottoRank = initializeLottoRankCountZero();
        initialLottoRank.putAll(lottoRanks);
        this.lottoRanks = initialLottoRank;
    }

    private Map<LottoRank, Long> initializeLottoRankCountZero() {
        return Arrays.stream(LottoRank.values())
                .collect(Collectors.toMap(lottoRank -> lottoRank, lottoRank -> 0L));
    }

    public double calculateProfitRate(int money) {
        return (calculateTotalPrizeMoney() / ((double) money * EACH_LOTTO_PRICE));
    }

    private long calculateTotalPrizeMoney() {
        return lottoRanks.keySet()
                .stream()
                .mapToLong(lottoRank -> lottoRank.getPrizeMoney() * lottoRanks.get(lottoRank))
                .sum();
    }

    @Override
    public String toString() {
        return "당첨 통계\n" +
                "---------\n" +
                "3개 일치 (5000원)- " + lottoRanks.get(LottoRank.FIFTH_PRIZE) + "개\n" +
                "4개 일치 (50000원)- " + lottoRanks.get(LottoRank.FOURTH_PRIZE) + "개\n" +
                "5개 일치 (1500000원)- " + lottoRanks.get(LottoRank.THIRD_PRIZE) + "개\n" +
                "5개 일치, 보너스 볼 일치(30000000원) - " + lottoRanks.get(LottoRank.SECOND_PRIZE) + "개\n" +
                "6개 일치 (2000000000)- " + lottoRanks.get(LottoRank.FIRST_PRIZE) + "개\n";
    }
}
