package lotto.ticker;

import lotto.number.LottoNumbers;

import java.util.Objects;

public class LottoTicket {
    private final LottoNumbers lottoNumbers;

    public LottoTicket(LottoNumbers lottoNumbers) {
        validate(lottoNumbers);
        this.lottoNumbers = lottoNumbers;
    }

    private void validate(LottoNumbers lottoNumbers) {
        if (Objects.isNull(lottoNumbers)) {
            throw new IllegalArgumentException("To init LottoTicket LottoNumbers can't be null");
        }
    }

    public static LottoTicket from(LottoNumbers lottoNumbers) {
        return new LottoTicket(lottoNumbers);
    }
}
