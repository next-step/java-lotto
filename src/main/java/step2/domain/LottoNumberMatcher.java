package step2.domain;

import java.util.EnumMap;
import java.util.List;
import java.util.Map;

public class LottoNumberMatcher {
    private final List<LottoNumbers> purchased;
    private final LottoNumbers winningNumbers;

    public LottoNumberMatcher(List<LottoNumbers> purchased, LottoNumbers winningNumbers) {
        this.purchased = purchased;
        this.winningNumbers = winningNumbers;
    }

    public LottoWinningRecord result() {
        Map<LottoRank, Integer> rankMap = new EnumMap<>(LottoRank.class);
        for (LottoRank rank : LottoRank.values()) {
            rankMap.put(rank, 0);
        }
        purchased.forEach(ticket -> {
            LottoRank rank = ticket.lottoRank(winningNumbers);
            rankMap.put(rank, rankMap.get(rank) + 1);
        });
        return new LottoWinningRecord(rankMap);
    }
}
