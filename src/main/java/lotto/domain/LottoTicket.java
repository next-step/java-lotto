package lotto.domain;

import java.util.List;
import java.util.stream.Collectors;

public class LottoTicket {
    public static final int LOTTO_SIZE = 6;
    private final List<LottoNumber> lottoNumbers;

    public LottoTicket(List<LottoNumber> lottoNumbers) {
        this.lottoNumbers = lottoNumbers;
    }

    public static LottoTicket of(List<Integer> numbers) {
        List<LottoNumber> lottoNumbers = numbers.stream()
                                                .map(LottoNumber::new)
                                                .collect(Collectors.toList());

        return new LottoTicket(lottoNumbers);
    }
}
