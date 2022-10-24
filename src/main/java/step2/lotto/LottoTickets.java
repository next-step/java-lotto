package step2.lotto;

import java.util.*;
import java.util.stream.Collectors;

public class LottoTickets {

    private static final int LOTTO_PRICE = 1_000;

    private final List<LottoTicket> lottoTickets;

    LottoTickets(List<LottoTicket> lottoTickets) {
        this.lottoTickets = lottoTickets;
    }

    public int numberOfTickets() {
        return lottoTickets.size();
    }

    public String yield(Set<Integer> winningNumbers) {
        double totalAmountEarned = lottoTickets.stream()
                .map(lottoTicket -> lottoTicket.rank(winningNumbers))
                .map(Rank::prizeAmount)
                .reduce(Double::sum)
                .orElse(0.0);

        return String.format("%.2f", totalAmountEarned / (LOTTO_PRICE * lottoTickets.size()));
    }

    public void print(OutputView outputView) {
        lottoTickets.forEach(lottoTicket -> lottoTicket.print(outputView));
    }

    public Map<Rank, Long> ranks(Set<Integer> winningNumbers) {
        return lottoTickets.stream()
                .map(lottoTicket -> lottoTicket.rank(winningNumbers))
                .filter(rank -> rank != Rank.NOTHING)
                .collect(Collectors.groupingBy(rank -> rank, Collectors.counting()));
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LottoTickets that = (LottoTickets) o;
        return Objects.equals(lottoTickets, that.lottoTickets);
    }

    @Override
    public int hashCode() {
        return Objects.hash(lottoTickets);
    }
}
