package study.lotto.domain;

import java.util.*;
import java.util.stream.Collectors;

public class LottoResult {
    private Map<LottoRank, List<LottoTicket>> winningTickets;
    private Amount investmentAmount;

    public LottoResult(List<LottoTicket> lottoTickets,
                       LottoWinningNumber lottoWinningNumber,
                       Amount investmentAmount) {
        this.investmentAmount = investmentAmount;
        setWinningTickets(lottoTickets, lottoWinningNumber);
    }

    public LottoResult(List<LottoTicket> lottoTickets,
                       LottoWinningNumber lottoWinningNumber,
                       int investmentAmount) {
        this(lottoTickets, lottoWinningNumber, new Amount(investmentAmount));
    }

    private void setWinningTickets(List<LottoTicket> lottoTickets,
                                   LottoWinningNumber lottoWinningNumber) {
        initWinningTickets();
        for (LottoTicket lottoTicket : lottoTickets) {
            LottoRank lottoRank = lottoWinningNumber.rank(lottoTicket);
            this.winningTickets.get(lottoRank).add(lottoTicket);
        }
    }

    private void initWinningTickets() {
        this.winningTickets = new HashMap<>();
        for (LottoRank lottoRank : LottoRank.values()) {
            this.winningTickets.put(lottoRank, new ArrayList<>());
        }
    }

    public List<LottoTicket> getWinningTickets(LottoRank lottoRank) {
        return winningTickets.get(lottoRank).stream()
                .map(LottoTicket::clone)
                .collect(Collectors.toList());
    }

    public double getRateOfReturn() {
        int prizeTotal = getPrizeTotal();

        return (double) prizeTotal / investmentAmount.getAmount();
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
