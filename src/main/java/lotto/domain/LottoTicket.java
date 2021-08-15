package lotto.domain;

import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class LottoTicket {

    private static final int LOTTO_NUMBER_SIZE = 6;

    private final List<LottoNumber> lottoNumbers;

    public LottoTicket(List<LottoNumber> lottoNumbers) {
        validate(lottoNumbers);
        this.lottoNumbers = lottoNumbers;
    }

    public List<LottoNumber> getLottoNumbers() {
        return Collections.unmodifiableList(lottoNumbers);
    }

    public boolean contains(LottoNumber lottoNumber) {
        return lottoNumbers.contains(lottoNumber);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LottoTicket lottoTicket = (LottoTicket) o;
        return Objects.equals(lottoNumbers, lottoTicket.lottoNumbers);
    }

    @Override
    public int hashCode() {
        return Objects.hash(lottoNumbers);
    }

    private void validate(List<LottoNumber> lottoNumbers) {
        if (lottoNumbers == null || isLottoNumberSize(lottoNumbers)) {
            throw new IllegalArgumentException("잘못된 지난 주 당첨 번호입니다.");
        }
    }


    private boolean isLottoNumberSize(List<LottoNumber> winningNumbers) {
        return winningNumbers.size() != LOTTO_NUMBER_SIZE;
    }
}
