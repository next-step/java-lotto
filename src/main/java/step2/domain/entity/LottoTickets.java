package step2.domain.entity;

import step2.domain.vo.LottoNumber;
import step2.domain.vo.LottoPrize;

import java.util.ArrayList;
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

    public List<LottoPrize> checkLottoPrize(Lotto winner, LottoNumber bonus) {
        List<LottoPrize> prizes = new ArrayList<>();

        for (LottoTicket ticket : lottoTickets) {
            final var prize = winner.prize(ticket.getLotto(), bonus);
            prizes.add(prize);
        }

        return prizes;
    }
}
