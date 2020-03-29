package lotto.domain;

import java.util.List;
import java.util.stream.Collectors;

public class Buyer {
    private List<LottoTicket> lottoTickets;

    public Buyer() {
    }

    public Buyer(List<LottoTicket> lottoTickets) {
        this.lottoTickets = lottoTickets;
    }

    public List<LottoTicket> buyLottoTickets(long money) {
        lottoTickets = LottoMachine.pay(money);
        return lottoTickets;
    }

    public BuyerResult getResult(LottoTicket winningTicket) {
        List<Rank> winningValues = getWinningValues(winningTicket);
        double profitRate = getProfitRate(winningValues);
        return new BuyerResult(winningValues, profitRate);
    }

    private double getProfitRate(List<Rank> winningValues) {
        long winningAmountSum = winningValues.stream()
                .mapToLong(Rank::getAmount)
                .sum();
        double profitRate = ((double) winningAmountSum) / (lottoTickets.size() * LottoTicket.PRICE);
        return Math.round(profitRate * 100) / 100.0;
    }

    private List<Rank> getWinningValues(LottoTicket winningTicket) {
        List<Integer> winningMatchCounts = lottoTickets.stream()
                .map(lottoTicket -> lottoTicket.compareTo(winningTicket))
                .filter(matchCount -> matchCount >= LottoTicket.WINNING_MIN_COUNT)
                .collect(Collectors.toList());

        return winningMatchCounts.stream()
                .map(Rank::findByMatchCount)
                .collect(Collectors.toList());
    }
}
