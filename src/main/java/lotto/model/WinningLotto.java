package lotto.model;

import java.util.Collections;
import java.util.Set;

import static lotto.model.Lotto.*;

public class WinningLotto {
    private final Set<LottoNumber> lottoNumbers;
    private final LottoNumber bonusBall;

    public WinningLotto(Set<LottoNumber> lottoNumbers, LottoNumber bonusBall) {
        validate(lottoNumbers, bonusBall);
        this.lottoNumbers = lottoNumbers;
        this.bonusBall = bonusBall;
    }

    private void validate(Set<LottoNumber> lottoNumbers, LottoNumber bonusBall) {
        if (lottoNumbers.size() != CORRECT_LOTTO_NUMBERS_SIZE) {
            throw new IllegalArgumentException(NOT_CORRECT_LOTTO_NUMBERS_MESSAGE);
        }
        if (lottoNumbers.contains(bonusBall)) {
            throw new IllegalArgumentException(DUPLICATED_LOTTO_NUMBERS_MESSAGE);
        }
    }

    public Set<LottoNumber> getLottoNumbers() {
        return Collections.unmodifiableSet(lottoNumbers);
    }

    public LottoNumber getBonusBall() {
        return bonusBall;
    }
}
