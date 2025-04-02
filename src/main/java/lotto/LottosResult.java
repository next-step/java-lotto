package lotto;

import java.util.EnumMap;
import java.util.List;

import static lotto.Lotto.LOTTO_PRICE;

public class LottosResult {

    private List<Lotto> lottos;
    private List<Integer> winningNumbers;
    private final EnumMap<LottoRank, Integer> lottoRankMap = new EnumMap<>(LottoRank.class);

    public LottosResult(List<Lotto> lottos, List<Integer> winningNumbers, int bonusNumber) {
        this.lottos = lottos;
        this.winningNumbers = winningNumbers;

        for (Lotto lotto : lottos) {
            LottoRank lottoRank = lotto.getLottoRank(winningNumbers, bonusNumber);
            lottoRankMap.put(
                    lottoRank,
                    lottoRankMap.getOrDefault(lottoRank, 0) + 1
            );
        }
    }

    public Integer getLottoRankCount(LottoRank lottoRank) {
        return lottoRankMap.getOrDefault(lottoRank, 0);
    }

    public double getTotalYieldRate() {
        return ((double) getTotalPrize() / (lottos.size() * LOTTO_PRICE));
    }

    private int getTotalPrize() {
        return lottoRankMap.entrySet().stream()
                .mapToInt(entry -> entry.getKey().getPrize() * entry.getValue())
                .sum();
    }
}
