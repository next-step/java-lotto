package lotto.domain;

import java.util.List;

public class LottoTicket {
    private static final int REQUIRED_SIZE = 6;
    private final List<LottoNumber> lottoNumbers;

    public LottoTicket(final List<LottoNumber> lottoNumbers) {
        validateSize(lottoNumbers);
        this.lottoNumbers = lottoNumbers;
    }

    private void validateSize(List<LottoNumber> lottoNumbers) {
        if (lottoNumbers.size() != REQUIRED_SIZE) {
            throw new RuntimeException("로또 번호는 6개여야만 합니다.");
        }
    }

    public List<LottoNumber> getLottoNumbers() {
        return lottoNumbers;
    }
}