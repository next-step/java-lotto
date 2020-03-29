package study.lotto.domain;

import java.util.*;
import java.util.stream.Collectors;

public class LottoResult {
    private Map<LottoRank, List<LottoTicket>> winningTickets;
    private int investmentAmount;

    public LottoResult(int investmentAmount) {
        this.investmentAmount = investmentAmount;
        setWinners();
    }

    private void setWinners() {
        this.winningTickets = new HashMap<>();
        this.winningTickets.put(LottoRank.FIRST, new ArrayList<>());
        this.winningTickets.put(LottoRank.SECOND, new ArrayList<>());
        this.winningTickets.put(LottoRank.THIRD, new ArrayList<>());
        this.winningTickets.put(LottoRank.FOURTH, new ArrayList<>());
    }

    public void addWinningTicket(LottoRank lottoRank, LottoTicket lottoTicket) {
        if (lottoRank != null) {
            this.winningTickets.get(lottoRank).add(lottoTicket);
        }
    }

    public List<LottoTicket> getWinningTickets(LottoRank lottoRank) {
        return winningTickets.get(lottoRank).stream()
                .map(LottoTicket::clone)
                .collect(Collectors.toList());
    }

    public double getRateOfReturn() {
        int prizeTotal = getPrizeTotal();

        return (double) prizeTotal / investmentAmount;
    }

    private int getPrizeTotal() {
        int prizeTotal = 0;
        for (LottoRank lottoRank : LottoRank.values()) {
            prizeTotal += this.winningTickets.get(lottoRank).size() *
                    lottoRank.getPrize();
        }
        return prizeTotal;
    }
}
