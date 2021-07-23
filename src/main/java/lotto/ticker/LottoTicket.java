package lotto.ticker;

import lotto.number.LottoNumbers;

public class LottoTicket {
    private final LottoNumbers lottoNumbers;

    public LottoTicket(LottoNumbers lottoNumbers) {
        this.lottoNumbers = lottoNumbers;
    }

    public static LottoTicket from(LottoNumbers lottoNumbers) {
        return new LottoTicket(lottoNumbers);
    }
}
