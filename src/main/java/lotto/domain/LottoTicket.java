package lotto.domain;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class LottoTicket {
    private final int LOTTO_NUMBER_COUNT = 6;
    private final List<LottoNumber> LottoTicket;

    public LottoTicket(List<LottoNumber> lottoNumbers) {
        validateLottoSize(lottoNumbers);
        validateDuplicate(lottoNumbers);
        this.LottoTicket = lottoNumbers;
    }

    private void validateLottoSize(List<LottoNumber> lottoNumbers) {
        if (lottoNumbers.size() != LOTTO_NUMBER_COUNT) {
            throw new IllegalArgumentException("로또 번호는 6자리여야 합니다.");
        }
    }

    private void validateDuplicate(List<LottoNumber> lottoNumbers) {
        Set<LottoNumber> lottoNumberSet = new HashSet<>(lottoNumbers);
        if (lottoNumberSet.size() != LOTTO_NUMBER_COUNT) {
            throw new IllegalArgumentException("로또 번호는 중복이 될 수 없습니다.");
        }
    }
}
