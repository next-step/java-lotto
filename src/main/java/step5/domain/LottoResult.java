package step5.domain;

import step5.domain.lottoticket.LottoTicket;
import step5.domain.lottoticket.WinningLottoTicket;

import java.util.*;

public class LottoResult {

    private Map<Rank, Integer> lottoResult = new LinkedHashMap<>();

    public LottoResult() {
        Arrays.asList(Rank.values())
            .forEach(rank -> lottoResult.put(rank, 0));
    }

    public void calculate(List<LottoTicket> lottoTickets, WinningLottoTicket winningLottoTicket) {
        for (LottoTicket lottoTicket : lottoTickets) {
            Long matchNumber = lottoTicket.matchWinningLotto(winningLottoTicket);
            boolean isMatched = lottoTicket.matchBonusBall(winningLottoTicket);
            Rank rank = Rank.valueOf(matchNumber, isMatched);
            lottoResult.put(rank, lottoResult.get(rank) + 1);
        }
    }

    public Map<Rank, Integer> result() {
        return lottoResult;
    }
}
