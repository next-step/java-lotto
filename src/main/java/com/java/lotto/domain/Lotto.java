package com.java.lotto.domain;

import java.util.List;
import java.util.Map;

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

    public Map<Integer, Integer> getWinningRecord() {
        return winningStatistics.getWinningRecord();
    }

    public int getWinNumberCount(int matchNumber) {
        if (winningStatistics.getWinningRecord().get(matchNumber) == null) {
            return 0;
        }
        return winningStatistics.getWinningRecord().get(matchNumber);
    }

    public int getLottoPrice() {
        return purchaseAmount;
    }
}
