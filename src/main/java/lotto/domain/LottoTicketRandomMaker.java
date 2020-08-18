package lotto.domain;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class LottoTicketRandomMaker implements LottoTicketMaker {
    public static final List<LottoNumber> LOTTO_NUMBERS;

    static {
        LOTTO_NUMBERS = Stream.iterate(LottoNumber.MIN_VALUE, number -> number + 1)
                .limit(LottoNumber.MAX_VALUE)
                .map(LottoNumber::of)
                .collect(Collectors.toList());
    }

    @Override
    public LottoTicket create() {
        Collections.shuffle(LOTTO_NUMBERS);

        List<LottoNumber> lottoNumbers = LOTTO_NUMBERS.stream()
                .limit(DEFAULT_LOTTO_NUMBER_COUNT)
                .collect(Collectors.toList());

        return LottoTicket.of(lottoNumbers);
    }
}
