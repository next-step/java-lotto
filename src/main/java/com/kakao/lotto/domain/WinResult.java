package com.kakao.lotto.domain;

import com.kakao.lotto.supportInfo.RankStatistic;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class WinResult {
    private final List<LottoTicket> userLottoTicket;
    private final WinLottoTicket winLottoTicket;

    public WinResult(List<LottoTicket> userLottoTicket, WinLottoTicket winLottoTicket) {
        this.userLottoTicket = userLottoTicket;
        this.winLottoTicket = winLottoTicket;
    }

    public RankStatistic createRankStatistic() {
        final Map<LottoRank, Integer> usersRankCount = Arrays.stream(LottoRank.values())
                .collect(Collectors.toMap(x -> x, this::getLottoRankCount));
        return new RankStatistic(usersRankCount);
    }

    private int getLottoRankCount(LottoRank lottoRank) {
        return (int) userLottoTicket.stream()
                .map(winLottoTicket::matchLottoRank)
                .filter(rank -> lottoRank == rank)
                .count();
    }

}
