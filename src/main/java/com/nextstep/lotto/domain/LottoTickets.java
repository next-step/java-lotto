package com.nextstep.lotto.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class LottoTickets {
    private final List<LottoTicket> lottoTickets;

    public LottoTickets(final List<LottoTicket> lottoTickets) {
        this.lottoTickets = new ArrayList<>(lottoTickets);
    }

    public LottoPrize checkResult(LottoTicket winningTicket) {
        List<Rank> resultRanks = lottoTickets.stream()
                .map(winningTicket::calculateRank)
                .filter(rank -> !rank.equals(Rank.NOTHING))
                .collect(Collectors.toList());

        return new LottoPrize(resultRanks);
    }

    public int size() {
        return this.lottoTickets.size();
    }

    public List<LottoTicket> getLottoTickets() {
        return new ArrayList<>(lottoTickets);
    }
}
