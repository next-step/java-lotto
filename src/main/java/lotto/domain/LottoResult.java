package lotto.domain;

import java.util.EnumMap;
import java.util.Map;
import java.util.Optional;

import static lotto.domain.LottoMachine.LOTTO_PRICE;

public class LottoResult {
    private final int lottoCount;
    private final Map<LottoRank, Integer> correctCounts = new EnumMap<>(LottoRank.class);

    public LottoResult(int lottoCount) {
        this.lottoCount = lottoCount;
        for (LottoRank lottoRank : LottoRank.values()) {
            correctCounts.put(lottoRank, 0);
        }
    }

    public int getCorrectCountsByLottoRank(LottoRank lottoRank) {
        return correctCounts.get(lottoRank);
    }

    private long winnings() {
        return (correctCounts.get(LottoRank.FIFTH) * LottoRank.FIFTH.getWinnings())
                + (correctCounts.get(LottoRank.FOURTH) * LottoRank.FOURTH.getWinnings())
                + (correctCounts.get(LottoRank.THIRD) * LottoRank.THIRD.getWinnings())
                + (correctCounts.get(LottoRank.SECOND) * LottoRank.SECOND.getWinnings())
                + (correctCounts.get(LottoRank.FIRST) * LottoRank.FIRST.getWinnings());
    }

    public void addCorrectLottoCount(int count, boolean isContainBonusNumber) {
        Optional<LottoRank> lottoRankOptional = LottoRank.findByCorrectCount(count, isContainBonusNumber);
        lottoRankOptional.ifPresent((lottoRank)->{
            correctCounts.put(lottoRank, correctCounts.get(lottoRank) + 1);
        });
    }

    public double rateOfReturn() {
        double rateOfReturn = (double) winnings() / (lottoCount * LOTTO_PRICE);
        return Math.floor(rateOfReturn * 100) / 100.0;
    }
}
