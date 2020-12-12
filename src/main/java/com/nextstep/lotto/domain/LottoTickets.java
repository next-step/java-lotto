package com.nextstep.lotto.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class LottoTickets {
    private final List<LottoTicket> lottoTickets;

    public LottoTickets(final List<LottoTicket> lottoTickets) {
        this.lottoTickets = new ArrayList<>(lottoTickets);
    }

    public LottoPrize checkResult(WinningTicket winningTicket) {
        List<Rank> resultRanks = lottoTickets.stream()
                .map(winningTicket::calculateRank)
                .collect(Collectors.toList());

        return new LottoPrize(resultRanks);
    }

    public List<LottoTicket> getLottoTickets() {
        return new ArrayList<>(lottoTickets);
    }

    int size() {
        return this.lottoTickets.size();
    }
}
