package lotto.domain;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class LottoTicketForm {
    private final LottoNumbers lottoNumbers;

    private LottoTicketForm(List<LottoNumber> lottoNumbers) {
        this.lottoNumbers = LottoNumbers.of(lottoNumbers);
    }

    public static LottoTicketForm of(List<LottoNumber> lottoNumbers) {
        return new LottoTicketForm(lottoNumbers);
    }

    public static LottoTicketForm of(int... lottoNumbers) {
        return new LottoTicketForm(Arrays.stream(lottoNumbers)
                .mapToObj(LottoNumber::of)
                .collect(Collectors.toList()));
    }

    public LottoNumbers getLottoNumbers() {
        return lottoNumbers;
    }
}
