package lotto.domain.ticket;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LottoTicketGenerator {
    private static final int LOTTO_NUMBERS_SIZE = 6;
    private final List<Integer> baseLottoNumbers;

    public LottoTicketGenerator() {
        baseLottoNumbers = getBase();
    }

    public LottoTicket getAuto() {
        Collections.shuffle(baseLottoNumbers);

        return new LottoTicket(baseLottoNumbers.stream()
                                               .limit(LOTTO_NUMBERS_SIZE)
                                               .sorted()
                                               .map(LottoNumber::new)
                                               .collect(Collectors.toList()));
    }

    private List<Integer> getBase() {
        List<Integer> baseLottoNumbers = new ArrayList<>();

        IntStream.rangeClosed(LottoNumber.LOTTO_NUMBER_MIN, LottoNumber.LOTTO_NUMBER_MAX)
                 .forEach(baseLottoNumbers::add);

        return baseLottoNumbers;
    }

}
