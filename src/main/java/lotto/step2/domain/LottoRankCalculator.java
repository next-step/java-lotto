package lotto.step2.domain;

import java.util.Arrays;
import java.util.EnumMap;
import java.util.List;

public class LottoRankCalculator {
    private final List<Lotto> lottos;

    private EnumMap<LottoRank, Integer> rankInfo;

    public LottoRankCalculator(final List<Lotto> lottos) {
        this.lottos = lottos;
        initialize();
    }

    private void initialize(){
        this.rankInfo = new EnumMap<>(LottoRank.class);
        Arrays.stream(LottoRank.values())
                .forEach(rank -> rankInfo.put(rank, 0));
    }

    public EnumMap<LottoRank, Integer> calculateLottoRank(List<Integer> winningNumbers) {
        LottoChecker checker = new LottoChecker(winningNumbers);

        for (Lotto lotto : lottos) {
            int matched = checker.matchWinningNumber(lotto);
            LottoRank rank = LottoRank.from(matched);
            rankInfo.put(rank, getRankCount(rank));
        }
        return rankInfo;
    }

    private Integer getRankCount(LottoRank rank) {
        if(rank.isNoneRank()){
            return 0;
        }
        return this.rankInfo.get(rank) + 1;
    }

}
