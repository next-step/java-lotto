package lotto.domain;

import lotto.domain.util.LottoNumberGenerator;
import lotto.domain.util.NumberGeneratorStrategy;

import java.util.List;
import java.util.stream.IntStream;

import static java.util.stream.Collectors.toUnmodifiableList;

public class LottoTickets {

    private final List<LottoNumbers> tickets;

    public LottoTickets(List<LottoNumbers> tickets) {
        this.tickets = tickets;
    }

    public static LottoTickets issue(PurchasedAmount purchasedAmount) {
        return issue(purchasedAmount, new LottoNumberGenerator());
    }

    public static LottoTickets issue(PurchasedAmount purchasedAmount, NumberGeneratorStrategy numberGeneratorStrategy) {
        int availableLottoCount = purchasedAmount.getAvailableLottoCount();
        List<LottoNumbers> issuedTickets = issueTickets(availableLottoCount, numberGeneratorStrategy);
        return new LottoTickets(issuedTickets);
    }

    private static List<LottoNumbers> issueTickets(int availableLottoCount, NumberGeneratorStrategy numberGeneratorStrategy) {
        return IntStream.range(0, availableLottoCount)
                .mapToObj(n -> numberGeneratorStrategy.generate())
                .collect(toUnmodifiableList());
    }

    public List<LottoNumbers> getTickets() {
        return tickets;
    }

    public int size() {
        return tickets.size();
    }

}