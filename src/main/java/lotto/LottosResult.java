package lotto;

import java.util.EnumMap;
import java.util.List;

import static lotto.Lotto.LOTTO_PRICE;

public class LottosResult {

    private List<Lotto> lottos;
    private List<Integer> winningNumbers;
    private EnumMap<LottoMatch, Integer> lottoMatchMap = new EnumMap<>(LottoMatch.class);

    public LottosResult(List<Lotto> lottos, List<Integer> winningNumbers) {
        this.lottos = lottos;
        this.winningNumbers = winningNumbers;

        for (Lotto lotto : lottos) {
            LottoMatch lottoMatch = lotto.getLottoMatch(winningNumbers);
            lottoMatchMap.put(
                    lottoMatch,
                    lottoMatchMap.getOrDefault(lotto.getLottoMatch(winningNumbers), 0) + 1
            );
        }
    }

    public Integer getLottoMatchCount(LottoMatch lottoMatch) {
        return lottoMatchMap.getOrDefault(lottoMatch, 0);
    }

    public double getTotalYieldRate() {
        return ((double) getTotalPrize() / (lottos.size() * LOTTO_PRICE));
    }

    private int getTotalPrize() {
        return lottoMatchMap.entrySet().stream()
                .mapToInt(entry -> entry.getKey().getPrize() * entry.getValue())
                .sum();
    }
}
