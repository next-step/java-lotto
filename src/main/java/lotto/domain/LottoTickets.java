package lotto.domain;

import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class LottoTickets {
    private static final int DEFAULT_VALUE = 0;
    private static final int ADD_COUNT = 1;

    private final List<LottoTicket> lottoTickets;

    public LottoTickets(List<LottoTicket> lottoTickets) {
        this.lottoTickets = lottoTickets;
    }

    public List<LottoTicket> getLottoTickets() {
        return lottoTickets;
    }

    public int lottoTicketCount() {
        return lottoTickets.size();
    }

    public LottoTickets union(LottoTickets randomLottoTickets) {
        return new LottoTickets(Stream.concat(lottoTickets.stream(), randomLottoTickets.getLottoTickets().stream())
                .collect(Collectors.toList()));
    }

    public LottoResult createLottoResult(WinningNumber winningNumber, LottoNumber bonusBall) {
        HashMap<LottoRank, Integer> results = new HashMap<>();
        for (LottoTicket lottoTicket : lottoTickets) {
            LottoRank lottoRank = LottoRank.getLottoRank(winningNumber.winningCount(lottoTicket), bonusBall.isMatchBall(lottoTicket));
            results.put(lottoRank, results.getOrDefault(lottoRank,DEFAULT_VALUE) + ADD_COUNT);
        }
        return new LottoResult(results);
    }
}
