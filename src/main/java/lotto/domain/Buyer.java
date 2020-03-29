package lotto.domain;

import java.util.List;
import java.util.stream.Collectors;

import static lotto.domain.LottoRule.*;

public class Buyer {
    private List<LottoTicket> lottoTickets;

    public Buyer() {
    }

    public Buyer(List<LottoTicket> lottoTickets) {
        this.lottoTickets = lottoTickets;
    }

    public List<LottoTicket> buyLottoTickets(int money) {
        lottoTickets = LottoMachine.pay(money);
        return lottoTickets;
    }

    public BuyerResult getResult(LottoTicket winningTicket) {
        List<WINNING_VALUE> winningValues = getWinningValues(winningTicket);
        double profitRate = getProfitRate(winningValues);
        return new BuyerResult(winningValues, profitRate);
    }

    private double getProfitRate(List<WINNING_VALUE> winningValues) {
        long winningAmountSum = winningValues.stream()
                .mapToLong(WINNING_VALUE::getAmount)
                .sum();
        double profitRate = ((double) winningAmountSum) / (lottoTickets.size() * getPrice());
        return Math.round(profitRate * 100) / 100.0;
    }

    private List<WINNING_VALUE> getWinningValues(LottoTicket winningTicket) {
        List<Integer> winningMatchCounts = lottoTickets.stream()
                .map(lottoTicket -> lottoTicket.compareTo(winningTicket))
                .filter(matchCount -> matchCount >= getWinningMinCount())
                .collect(Collectors.toList());

        return winningMatchCounts.stream()
                .map(WINNING_VALUE::findByMatchCount)
                .collect(Collectors.toList());
    }
}
