package lotto.model;

import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static lotto.util.MessageUtil.WARNING_LOTTO_NON_DUPLICATION;
import static lotto.util.MessageUtil.WARNING_LOTTO_SIZE;

public class Lotto {
    private List<LottoNumber> lottoNumbers;

    public Lotto(List<LottoNumber> lotto) {
        validateSizeSix(lotto);
        validateDuplication(lotto);
        this.lottoNumbers = Collections.unmodifiableList(lotto);
    }

    public boolean hasBonusBallNumber(LottoNumber bonusBall){
        return lottoNumbers.contains(bonusBall);
    }

    private void validateSizeSix(List<LottoNumber> lotto) {
        if (lotto.size() != 6) {
            throw new IllegalArgumentException(WARNING_LOTTO_SIZE);
        }
    }

    private void validateDuplication(List<LottoNumber> lotto) {
        Set<LottoNumber> normalLotto = new HashSet<>(lotto);

        if (normalLotto.size() != 6) {
            throw new IllegalArgumentException(WARNING_LOTTO_NON_DUPLICATION);
        }
    }

    @Override
    public String toString() {
        return String.valueOf(lottoNumbers);
    }

    public Rank match(WinningLotto winningLotto) {
        return null;
    }
}