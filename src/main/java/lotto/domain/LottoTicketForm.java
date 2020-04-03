package lotto.domain;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class LottoTicketForm {
    private final LottoNumbers lottoNumbers;


    public static LottoTicketForm of(List<LottoNumber> lottoNumbers) {
        return new LottoTicketForm(LottoNumbers.of(lottoNumbers));
    }

    public static LottoTicketForm of(int... lottoNumbers) {
        return new LottoTicketForm(LottoNumbers.of(Arrays.stream(lottoNumbers)
                .mapToObj(LottoNumber::of)
                .collect(Collectors.toList())));
    }

    private LottoTicketForm(LottoNumbers lottoNumbers) {
        this.lottoNumbers = lottoNumbers;
    }

    public LottoNumbers getLottoNumbers() {
        return lottoNumbers;
    }
}
