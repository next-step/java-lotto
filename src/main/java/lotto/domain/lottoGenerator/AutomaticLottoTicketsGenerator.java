package lotto.domain.lottoGenerator;

import lotto.domain.LottoNumber;
import lotto.domain.LottoTicket;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.IntStream;

import static java.util.stream.Collectors.toList;
import static lotto.domain.LottoProperties.*;

public class AutomaticLottoTicketsGenerator implements LottoTicketsGenerator {

    private static final List<LottoNumber> NUMBERS = IntStream
            .rangeClosed(MIN_LOTTO_NUMBER, MAX_LOTTO_NUMBER)
            .mapToObj(LottoNumber::from)
            .collect(toList());

    private final int numberOfTickets;

    public AutomaticLottoTicketsGenerator(int numberOfTickets) {
        this.numberOfTickets = numberOfTickets;
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
        List<LottoNumber> lottoNumbers = NUMBERS.stream()
                .limit(NUMBER_OF_LOTTO_NUMBERS)
                .collect(toList());
        return LottoTicket.from(lottoNumbers);
    }


}
