package step2.model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LottoResult {

    private static final int EACH_LOTTO_PRICE = 1000;

    private final List<LottoRank> lottoRanks;

    public LottoResult(List<LottoRank> lottoRanks) {
        this.lottoRanks = lottoRanks;
    }

    public LottoResult(LottoRank... lottoRanks) {
        this.lottoRanks = new ArrayList<>(Arrays.asList(lottoRanks));
    }

    public double calculateProfitRate(int money) {
        return (calculateTotalPrizeMoney() / ((double) money * EACH_LOTTO_PRICE));
    }

    private long calculateTotalPrizeMoney() {
        return this.lottoRanks.stream()
                .mapToLong(LottoRank::getPrizeMoney) //todo print문이 아님에도 get함수 사용중.
                .sum();
    }

    @Override
    public String toString() {
        Map<LottoRank, Long> result = countByLottoRank();
        return "당첨 통계\n" +
                "---------\n" +
                "3개 일치 (5000원)- " + result.get(LottoRank.FIFTH_PRIZE) + "개\n" +
                "4개 일치 (50000원)- " + result.get(LottoRank.FOURTH_PRIZE) + "개\n" +
                "5개 일치 (1500000원)- " + result.get(LottoRank.THIRD_PRIZE) + "개\n" +
                "5개 일치, 보너스 볼 일치(30000000원) - " + result.get(LottoRank.SECOND_PRIZE) + "개\n" +
                "6개 일치 (2000000000)- " + result.get(LottoRank.FIRST_PRIZE) + "개\n";
    }

    private Map<LottoRank, Long> countByLottoRank() {
        Map<LottoRank, Long> result = new HashMap<>();
        for (LottoRank lottoRank : LottoRank.values()) {
            result.put(lottoRank, lottoRanks.stream().filter(rank -> rank == lottoRank).count());
        }
        return result;
    }
}
