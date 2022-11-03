package lotto.domain;

import lotto.domain.lottogenerator.LottoGenerator;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Store {

    private static final int PRICE_OF_LOTTO_TICKET = 1000;
    private final LottoGenerator lottoGenerator;
    private final List<LottoTicket> lottoTickets;

    public Store(final LottoGenerator lottoGenerator, final Money money) {
        this.lottoGenerator = lottoGenerator;
        this.lottoTickets = createLottoTickets(money.countOfTickets(PRICE_OF_LOTTO_TICKET));
    }

    private List<LottoTicket> createLottoTickets(final int countOfTickets) {
        return lottoGenerator.create(countOfTickets);
    }
    public List<Rank> match(final WinningLotto winningLotto) {
        return lottoTickets.stream()
                .map(winningLotto::match)
                .collect(Collectors.toList());
    }

    public List<LottoTicket> getLottoTickets() {
        return Collections.unmodifiableList(this.lottoTickets);
    }

}
