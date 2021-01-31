package lotto.domain;

import lotto.resources.StringResources;

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
            throw new RuntimeException(StringResources.LOTTO_NUMBER_AMOUNT_ERROR_MESSAGE);
        }
    }

    public List<LottoNumber> getLottoNumbers() {
        return lottoNumbers;
    }

    @Override
    public String toString() {
        return this.lottoNumbers.toString();
    }
}