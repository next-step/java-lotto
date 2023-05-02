package step2.domain.entity;

import step2.domain.vo.LottoPrize;

import java.util.Arrays;
import java.util.List;

public class LottoTickets {

    private List<LottoTicket> lottoTickets;

    public LottoTickets(List<LottoTicket> lottoTickets) {
        this.lottoTickets = lottoTickets;
    }

    public LottoTickets(LottoTicket... lottoTickets) {
        this(Arrays.asList(lottoTickets));
    }

    public List<LottoTicket> getLottoTickets() {
        return lottoTickets;
    }

    public int size() {
        return this.lottoTickets.size();
    }

    public int getLottoRankCount(LottoPrize prize) {
        return (int) lottoTickets.stream()
                .filter(lottoTicket -> lottoTicket.getLottoPrize().equals(prize))
                .count();
    }

    public double getTotalRate() {
        double rate = (double) getTotalAmount() / getTotalMoney();
        return Math.floor(rate * 100.0) / 100.0;
    }

    private long getTotalAmount() {
        return lottoTickets.stream()
                .mapToLong(ticket -> ticket.getLottoPrize().getPrize())
                .sum();
    }

    private int getTotalMoney() {
        return Lotto.PRICE * this.size();
    }
}
