package com.kakao.lotto.domain;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class LottoTicketCollection {
    private final List<LottoTicket> lottoTickets;

    public LottoTicketCollection(List<LottoTicket> lottoTickets) {
        this.lottoTickets = lottoTickets;
    }

    public List<LottoTicket> getLottoTickets() {
        return Collections.unmodifiableList(lottoTickets);
    }

    public RankStatistic createRankStatistic(WinLottoTicket winLottoTicket) {
        final Map<LottoRank, Integer> usersRankCount = Arrays.stream(LottoRank.values())
                .collect(Collectors.toMap(x -> x, x -> getLottoRankCount(x, winLottoTicket)));
        return new RankStatistic(usersRankCount);
    }

    private int getLottoRankCount(LottoRank lottoRank, WinLottoTicket winLottoTicket) {
        return (int) lottoTickets.stream()
                .map(winLottoTicket::matchLottoRank)
                .filter(rank -> lottoRank == rank)
                .count();
    }
}
