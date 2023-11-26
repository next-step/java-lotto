package step2.domain;

import java.util.*;
import java.util.stream.Collectors;

public class LottoResult {

    private Map<LottoRank, Integer> lottoRankResult = new HashMap<>();
    public static final int LOTTO_MATCH_MIN=0;
    public static final int LOTTO_MATCH_MAX=6;

    public LottoResult(List<LottoTicket> tickets, LottoWinningTicket winningTicket) {
        process(tickets, winningTicket);
    }

    public LottoResult(Map<LottoRank, Integer> result) {
        this.lottoRankResult = result;
    }

    private void process(List<LottoTicket> tickets, LottoWinningTicket winningTicket) {
            lottoRankResult = tickets.stream()
                .map(ticket -> LottoRank.lottoRank(ticket.matchCount(winningTicket.winningTicket()), ticket.bonusMatch(winningTicket.bonusNumber())))
                .collect(Collectors.groupingBy(LottoRank::valueOf, Collectors.summingInt(e -> 1)));
            Arrays.stream(LottoRank.VALUES).forEach(lottoRank -> {lottoRankResult.putIfAbsent(lottoRank, 0);});
    }

    public Map<LottoRank, Integer> result() {
        return lottoRankResult;
    }

    public int matchCount(LottoRank lottoRank) {
        return lottoRankResult.get(lottoRank);
    }
}
