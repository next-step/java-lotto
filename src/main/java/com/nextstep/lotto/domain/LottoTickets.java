package com.nextstep.lotto.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

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

    public LottoTickets merge(LottoTickets thatTicket) {
        List<LottoTicket> mergedLottoTickets = Stream.of(this.lottoTickets, thatTicket.lottoTickets)
                .flatMap(it -> it.stream())
                .collect(Collectors.toList());

        return new LottoTickets(mergedLottoTickets);
    }

    public List<LottoTicket> getLottoTickets() {
        return new ArrayList<>(lottoTickets);
    }

    public int size() {
        return this.lottoTickets.size();
    }
}
