package lotto.domain;


import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LottoMatcher {

    public static final int DEFAULT_COUNT = 0;
    public final Map<LottoRank, Integer> rankResult;

    public LottoMatcher(List<LottoTicket> lottoTickets, WinningLotto winningLotto) {
        rankResult = aggregateRank(lottoTickets, winningLotto);
    }

    private LottoRank checkRank(LottoTicket lottoTicket, WinningLotto winningLotto) {
        return LottoRank.valueOf(lottoTicket.matchCount(winningLotto), lottoTicket.isBonusMatch());
    }

    private Map<LottoRank, Integer> aggregateRank(List<LottoTicket> lottoTickets, WinningLotto winningLotto) {
        Map<LottoRank, Integer> rankResult = initialize();

        for (LottoTicket lottoTicket : lottoTickets) {
            LottoRank lottoRank = checkRank(lottoTicket, winningLotto);
            rankResult.computeIfPresent(lottoRank, (LottoRank key, Integer matchCount) -> ++matchCount);
        }
        return rankResult;
    }

    private Map<LottoRank, Integer> initialize() {
        Map<LottoRank, Integer> rankResult = new HashMap<>();
        for (LottoRank lottoRank : LottoRank.values()) {
            if (lottoRank == LottoRank.MISS) continue;
            rankResult.put(lottoRank, DEFAULT_COUNT);
        }
        return rankResult;
    }
}
