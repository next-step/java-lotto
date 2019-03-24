package lotto.domain;


import java.util.HashMap;
import java.util.List;

public class LottoMatcher {

    public final HashMap<LottoRank, Integer> rankResult;

    public LottoMatcher(List<LottoTicket> lottoTickets, WinningLotto winningLotto) {
        rankResult = aggregateRank(lottoTickets, winningLotto);
    }

    private LottoRank checkRank(LottoTicket lottoTicket, WinningLotto winningLotto) {
        return LottoRank.valueOf(lottoTicket.matchCount(winningLotto), lottoTicket.isBonusMatch());
    }

    private HashMap<LottoRank, Integer> aggregateRank(List<LottoTicket> lottoTickets, WinningLotto winningLotto) {
        HashMap<LottoRank, Integer> rankResult = initialize();

        for (LottoTicket lottoTicket : lottoTickets) {
            LottoRank lottoRank = checkRank(lottoTicket, winningLotto);
            rankResult.computeIfPresent(lottoRank, (LottoRank key, Integer value) -> ++value);
//            rankResult.putIfAbsent(lottoRank, 1);
        }
        return rankResult;
    }

    private HashMap<LottoRank, Integer> initialize() {
        HashMap<LottoRank, Integer> rankResult = new HashMap<>();
        for (LottoRank lottoRank : LottoRank.values()) {
            if (lottoRank == LottoRank.MISS) continue;
            rankResult.put(lottoRank, 0);
        }
        return rankResult;
    }
}
