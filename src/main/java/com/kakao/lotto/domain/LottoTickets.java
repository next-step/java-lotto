package com.kakao.lotto.domain;

import com.kakao.lotto.supportInfo.RankStatistic;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class LottoTickets {
    private final List<LottoTicket> lottoTickets;

    public LottoTickets(List<LottoTicket> lottoTickets) {
        this.lottoTickets = lottoTickets;
    }

    public List<LottoTicket> getLottoTickets() {
        return Collections.unmodifiableList(lottoTickets);
    }

    public RankStatistic createRankStatistic(WinLottoTicket winLottoTicket, int inputMoney) {
        final Map<LottoRank, Integer> usersRankCount = Arrays.stream(LottoRank.values())
                .collect(Collectors.toMap(x -> x, x -> getLottoRankCount(x, winLottoTicket)));
        return new RankStatistic(usersRankCount, inputMoney);
    }

    private int getLottoRankCount(LottoRank lottoRank, WinLottoTicket winLottoTicket) {
        return (int) lottoTickets.stream()
                .map(winLottoTicket::matchLottoRank)
                .filter(rank -> lottoRank == rank)
                .count();
    }

    public LottoTickets createMergedTicket(LottoTickets addLottoTickets){
        List<LottoTicket> mergedTicket = Stream.concat(lottoTickets.stream(), addLottoTickets.lottoTickets.stream())
                .collect(Collectors.toList());
        return new LottoTickets(mergedTicket);
    }
}
