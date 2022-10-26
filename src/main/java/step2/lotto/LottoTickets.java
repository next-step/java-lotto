package step2.lotto;

import java.util.*;
import java.util.stream.Collectors;

public class LottoTickets {

    private final List<LottoTicket> lottoTickets;

    private final int lottoPrice;

    public LottoTickets(List<LottoTicket> lottoTickets, int lottoPrice) {
        this.lottoTickets = lottoTickets;
        this.lottoPrice = lottoPrice;
    }

    public int numberOfTickets() {
        return lottoTickets.size();
    }

    public void printNumbers(OutputDevice outputDevice) {
        lottoTickets.forEach(lottoTicket -> lottoTicket.printNumbers(outputDevice));
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

    public YieldCalculator yieldCalculator(Set<Integer> winningNumbers) {
        return new YieldCalculator(lottoPrice, ranks(winningNumbers));
    }

    private List<Rank> ranks(Set<Integer> winningNumbers) {
        return lottoTickets.stream()
                .map(lottoTicket -> lottoTicket.rank(winningNumbers))
                .collect(Collectors.toUnmodifiableList());
    }

    public MatchIndicatorCalculator matchIndicatorCalculator(Set<Integer> winningNumbers) {
        return new MatchIndicatorCalculator(ranks(winningNumbers));
    }
}

