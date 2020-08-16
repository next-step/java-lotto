package lotto.domain;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class LottoTicket {
    public static final int DEFAULT_LOTTO_NUMBER_COUNT = 6;
    private static final List<LottoNumber> LOTTO_NUMBERS;

    private List<LottoNumber> lottoNumbers;

    static {
        LOTTO_NUMBERS = Stream.iterate(LottoNumber.MIN_VALUE, number -> number + 1)
                .limit(LottoNumber.MAX_VALUE)
                .map(LottoNumber::of)
                .collect(Collectors.toList());
    }

    private LottoTicket(List<LottoNumber> lottoNumbers) {
        this.lottoNumbers = lottoNumbers;
    }

    public static LottoTicket create() {
        Collections.shuffle(LOTTO_NUMBERS);

        List<LottoNumber> lottoNumbers = LOTTO_NUMBERS.stream()
                .limit(DEFAULT_LOTTO_NUMBER_COUNT)
                .collect(Collectors.toList());

        return new LottoTicket(lottoNumbers);
    }

    public static List<LottoNumber> stream(LottoTicket lottoTicket) {
        return lottoTicket.lottoNumbers;
    }
}
