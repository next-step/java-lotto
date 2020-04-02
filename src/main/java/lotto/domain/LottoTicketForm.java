package lotto.domain;

import java.util.List;

public class LottoTicketForm {
    private final LottoNumbers lottoNumbers;

    private LottoTicketForm(List<LottoNumber> lottoNumbers) {
        this.lottoNumbers = LottoNumbers.of(lottoNumbers);
    }

    public static LottoTicketForm of(List<LottoNumber> lottoNumbers) {
        return new LottoTicketForm(lottoNumbers);
    }
}
