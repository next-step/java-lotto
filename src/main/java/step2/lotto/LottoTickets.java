package step2.lotto;

import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LottoTickets {

    private static final int LOTTO_PRICE = 1_000;

    private final List<LottoTicket> lottoTickets;

    private LottoTickets(List<LottoTicket> lottoTickets) {
        this.lottoTickets = lottoTickets;
    }

    public static LottoTickets of(int price, NumbersGenerator numbersGenerator) {
        int numberOfTickets = price / LOTTO_PRICE;

        List<LottoTicket> lottoTickets = IntStream.range(0, numberOfTickets)
                .mapToObj(numberOfTicket -> LottoTicket.from(numbersGenerator))
                .collect(Collectors.toUnmodifiableList());

        return new LottoTickets(lottoTickets);
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
                .collect(Collectors.groupingBy(rank -> rank, Collectors.counting()));
    }

}
