package lotto.domain.strategy;

import lotto.domain.LottoNumber;
import lotto.domain.LottoTicket;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.IntStream;

import static java.util.stream.Collectors.collectingAndThen;
import static java.util.stream.Collectors.toList;
import static lotto.domain.LottoProperties.*;

public class AutomaticLottoTicketsGenerator implements LottoTicketsGenerator {

    public static final int LOTTO_NUMBER_MIN_INDEX = 0;
    private static final int LOTTO_NUMBER_MAX_INDEX = NUMBER_OF_LOTTO_NUMBERS - 1;
    private static final List<LottoNumber> NUMBERS = IntStream
            .rangeClosed(MIN_LOTTO_NUMBER, MAX_LOTTO_NUMBER)
            .mapToObj(LottoNumber::from)
            .collect(toList());

    private final int numberOfTickets;
    private final int ticketsPrice;

    public AutomaticLottoTicketsGenerator(int numberOfTickets, int ticketPrice) {
        this.numberOfTickets = numberOfTickets;
        this.ticketsPrice = ticketPrice * numberOfTickets;
    }

    @Override
    public List<LottoTicket> generate() {
        List<LottoTicket> lottoTickets = new ArrayList<>();
        for (int i = 0; i < this.numberOfTickets; i++) {
            lottoTickets.add(generateLottoTicket());
        }
        return lottoTickets;
    }

    private static LottoTicket generateLottoTicket() {
        Collections.shuffle(NUMBERS);
        List<LottoNumber> lottoNumbers = IntStream.rangeClosed(LOTTO_NUMBER_MIN_INDEX, LOTTO_NUMBER_MAX_INDEX)
                .mapToObj(NUMBERS::get)
                .sorted()
                .collect(collectingAndThen(toList(), Collections::unmodifiableList));

        return LottoTicket.from(lottoNumbers);
    }

    @Override
    public int ticketsPrice() {
        return this.ticketsPrice;
    }

}
