package step2.domain.entity;

import step2.domain.vo.LottoPrize;

import java.util.List;

public class LottoTickets {

    private List<LottoTicket> lottoTickets;

    public LottoTickets(List<LottoTicket> lottoTickets) {
        this.lottoTickets = lottoTickets;
    }

    public List<LottoTicket> getLottoTickets() {
        return lottoTickets;
    }

    public int size() {
        return this.lottoTickets.size();
    }

    public int getLottoRankCount(LottoPrize prize, List<LottoPrize> lottoPrizes) {
        return (int) lottoPrizes.stream()
                .filter(lottoPrize -> lottoPrize.equals(prize))
                .count();
    }

    public double getTotalRate(List<LottoPrize> lottoPrizes) {
        double rate = (double) getTotalAmount(lottoPrizes) / getTotalMoney();
        return Math.floor(rate * 100.0) / 100.0;
    }

    private long getTotalAmount(List<LottoPrize> lottoPrizes) {
        return lottoPrizes.stream()
                .mapToLong(LottoPrize::getPrize)
                .sum();
    }

    private int getTotalMoney() {
        return Lotto.PRICE * this.size();
    }
}
