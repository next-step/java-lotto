package lotto.step2.domain;

import java.util.Arrays;
import java.util.EnumMap;
import java.util.List;

public class LottoRankCalculator {
    private final List<Lotto> lottos;
    private final WinningNumbers winningNumbers;

    private EnumMap<LottoRank, Integer> rankInfo;

    public LottoRankCalculator(final List<Lotto> lottos, final WinningNumbers winningNumbers) {
        this.lottos = lottos;
        this.winningNumbers = winningNumbers;
        initialize();
    }

    private void initialize(){
        this.rankInfo = new EnumMap<>(LottoRank.class);
        Arrays.stream(LottoRank.values())
                .forEach(rank -> rankInfo.put(rank, 0));

        calculateLottoRank();
    }

    private void calculateLottoRank() {
        for (Lotto lotto : lottos) {
            int matched = winningNumbers.matchWinningNumber(lotto);
            LottoRank rank = LottoRank.from(matched);
            rankInfo.put(rank, getRankCount(rank));
        }
    }

    public int findMatchCount(int match) {
        LottoRank rank = LottoRank.from(match);
        return rankInfo.get(rank);
    }

    private Integer getRankCount(LottoRank rank) {
        if(rank.isNoneRank()){
            return 0;
        }
        return this.rankInfo.get(rank) + 1;
    }

    public int calculateWinningAmount(){
        int totalAmount = 0;

        for (LottoRank rank : rankInfo.keySet()) {
            int amountByRank = amountByRank(rank);
            totalAmount += amountByRank;
        }

        return totalAmount;
    }

    private int amountByRank(LottoRank rank) {
        int rankCount = rankInfo.get(rank);
        int prizeByRank = rank.prize();

        return prizeByRank * rankCount;
    }
}
