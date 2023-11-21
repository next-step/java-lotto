package step2.model;

import java.util.Arrays;
import java.util.EnumMap;
import java.util.function.Function;
import java.util.stream.Collectors;

public class LottoResult {

    private static final int EACH_LOTTO_PRICE = 1000;

    private final EnumMap<LottoRank, Long> lottoRanks;

    public LottoResult(EnumMap<LottoRank, Long> lottoRanks) {
        EnumMap<LottoRank, Long> initialLottoRank = initializeLottoRankCountZero();
        initialLottoRank.putAll(lottoRanks);
        this.lottoRanks = initialLottoRank;
    }

    private EnumMap<LottoRank, Long> initializeLottoRankCountZero() {
        return new EnumMap<>(Arrays.stream(LottoRank.values())
                .collect(Collectors.toMap(Function.identity(), lottoRank -> 0L)));
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
        StringBuilder message = new StringBuilder("당첨 통계\n" + "---------\n");
        lottoRanks.keySet()
                .forEach(lottoRank -> message.append(String.format(lottoRank.getPrintMessage(), lottoRanks.get(lottoRank))));
        return message.toString();
    }

}
