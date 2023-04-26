package lotto.domain;

import java.util.List;
import java.util.stream.IntStream;

import static java.util.stream.Collectors.toUnmodifiableList;

public class LottoTickets {

    private final List<LottoNumbers> tickets;

    public LottoTickets(List<LottoNumbers> tickets) {
        this.tickets = tickets;
    }

    public static LottoTickets issue(PurchasedAmount purchasedAmount) {
        int availableLottoCount = purchasedAmount.getAvailableLottoCount();
        List<LottoNumbers> issuedTickets = issueTickets(availableLottoCount);
        return new LottoTickets(issuedTickets);
    }

    private static List<LottoNumbers> issueTickets(int availableLottoCount) {
        return IntStream.range(0, availableLottoCount)
                .mapToObj(n -> LottoNumbers.generate())
                .collect(toUnmodifiableList());
    }

    public List<LottoNumbers> getTickets() {
        return tickets;
    }

    public int size() {
        return tickets.size();
    }

}