package lotto.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static lotto.domain.LottoNumber.MAX_LOTTO_NUMBER;
import static lotto.domain.LottoNumber.MIN_LOTTO_NUMBER;

public class Store {

    private static final int PRICE_OF_LOTTO_TICKET = 1000;

    private final List<LottoTicket> lottoTickets;

    public Store(final Money money) {
        this.lottoTickets = createLottoTickets(money.countOfTickets(PRICE_OF_LOTTO_TICKET));
    }

    private List<LottoTicket> createLottoTickets(final int countOfTickets) {
        return IntStream.range(0, countOfTickets)
                .mapToObj(i -> createLottoTicket())
                .collect(Collectors.toList());
    }

    private LottoTicket createLottoTicket() {
        List<Integer> numList = new ArrayList<>();
        for (int i = MIN_LOTTO_NUMBER; i <= MAX_LOTTO_NUMBER; i++) {
            numList.add(i);
        }
        Collections.shuffle(numList);
        return new LottoTicket(numList.subList(0, LottoTicket.LOTTO_NUMBER_SIZE));
    }

    public List<Rank> match(final List<LottoNumber> winningNumbers) {
        List<Rank> ranks = new ArrayList<>();
        for (LottoTicket lottoTicket : lottoTickets) {
            ranks.add(lottoTicket.match(winningNumbers));
        }
        return ranks;
    }

    public List<LottoTicket> getLottoTickets() {
        return Collections.unmodifiableList(this.lottoTickets);
    }

}
