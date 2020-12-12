package lotto.domain;

import java.util.List;

public class LottoTicket {
    private static final int LOTTO_NUMBERS_SIZE = 6;

    private final List<LottoNumber> LottoNumbers;

    public LottoTicket(List<LottoNumber> lottoNumbers) {
        validate(lottoNumbers);
        LottoNumbers = lottoNumbers;
    }

    private void validate(List<LottoNumber> lottoNumbers) {
        if (lottoNumbers.size() != LOTTO_NUMBERS_SIZE) {
            throw new IllegalArgumentException("로또 숫자가 부족합니다.");
        }
    }

    public List<LottoNumber> getLottoNumbers() {
        return LottoNumbers;
    }
}
