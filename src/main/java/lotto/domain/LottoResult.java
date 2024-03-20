package lotto.domain;

import java.util.EnumMap;
import java.util.Optional;

import static lotto.domain.LottoMachine.LOTTO_PRICE;

public class LottoResult {
    private int lottoCount = 0;
    private final EnumMap<LottoRank, Integer> correctCounts = new EnumMap<>(LottoRank.class);

    public LottoResult() {
        for (LottoRank lottoRank : LottoRank.values()) {
            correctCounts.put(lottoRank, 0);
        }
    }

    public int getCorrectCountsByLottoRank(LottoRank lottoRank) {
        return correctCounts.get(lottoRank);
    }

    private long winnings() {
        return (correctCounts.get(LottoRank.THREE_NUMBER_CORRECT) * LottoRank.THREE_NUMBER_CORRECT.getWinnings())
                + (correctCounts.get(LottoRank.FOUR_NUMBER_CORRECT) * LottoRank.FOUR_NUMBER_CORRECT.getWinnings())
                + (correctCounts.get(LottoRank.FIVE_NUMBER_CORRECT) * LottoRank.FIVE_NUMBER_CORRECT.getWinnings())
                + (correctCounts.get(LottoRank.SIX_NUMBER_CORRECT) * LottoRank.SIX_NUMBER_CORRECT.getWinnings());
    }

    public void addCorrectLottoCount(int count) {
        Optional<LottoRank> lottoRankOptional = LottoRank.findByCorrectCount(count);
        if (lottoRankOptional.isEmpty()) {
            return;
        }
        lottoCount++;
        LottoRank lottoRank = lottoRankOptional.get();
        correctCounts.put(lottoRank, correctCounts.get(lottoRank) + 1);
    }

    public double rateOfReturn() {
        double rateOfReturn = (double) winnings() / (lottoCount * LOTTO_PRICE);
        return Math.floor(rateOfReturn * 100) / 100.0;
    }
}
