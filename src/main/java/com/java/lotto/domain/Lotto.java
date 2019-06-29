package com.java.lotto.domain;

import java.util.List;
import java.util.Map;
import java.util.Set;

public class Lotto {
    public static final int LOTTO_PRICE = 1000;

    private int purchaseAmount;
    private LottoTickets lottoTickets;
    private LottoWinningStatistics winningStatistics;

    public Lotto(int purchaseAmount) {
        this.purchaseAmount = purchaseAmount;
        this.lottoTickets = purchase(purchaseAmount);
        this.winningStatistics = new LottoWinningStatistics();
    }

    private LottoTickets purchase(int purchaseAmount) {
        return LottoTicketsGenerator.automaticTicketsGenerator(purchaseAmount / LOTTO_PRICE);
    }

    public void findLottoWinning(List<Integer> winningTicket) {
        winningStatistics.findLottoWinning(winningTicket, lottoTickets);
    }

    public List<LottoTicket> getLottoTickets() {
        return lottoTickets.getLottoTickets();
    }

    public int getLottoTicketsCount() {
        return lottoTickets.count();
    }

    public Map<LottoReward, Integer> getWinningStatistics() {
        return winningStatistics.isWinningStatistics();
    }

    public float rateOfReturn() {
        return winningStatistics.rateOfReturn(purchaseAmount);
    }

    public Set<LottoReward> rank(){
        return getWinningStatistics().keySet();
    }

    public Integer numberOfRank(LottoReward lottoReward){
        return getWinningStatistics().get(lottoReward);
    }
}
