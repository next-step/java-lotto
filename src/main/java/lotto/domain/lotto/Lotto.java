package lotto.domain.lotto;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Lotto {

    private static final int LOTTO_SIZE = 6;
    private static final String NOT_VALIDATE_LOTTO_MESSAGE = "[ERROR] 로또는 중복되지 않은 6개의 숫자가 필요합니다.";
    private static final String NOT_VALIDATE_SIZE_LOTTO_MESSAGE = "[ERROR] 로또는 6개의 숫자가 필요합니다.";

    private List<LottoNumber> lotto;

    public Lotto(List<LottoNumber> lotto) {
        validateDuplicates(lotto);
        this.lotto = lotto;
        validateLotto();
    }

    public Lotto(Set<LottoNumber> lotto) {
        this.lotto = new ArrayList<>(lotto);
        validateLotto();
    }

    public int count() {
        return lotto.size();
    }

    public boolean hasValue(LottoNumber lottoNumber) {
        return lotto.contains(lottoNumber);
    }

    public List<LottoNumber> values() {
        return Collections.unmodifiableList(lotto);
    }

    private void validateDuplicates(List<LottoNumber> lotto) {
        Set<LottoNumber> lottoNumbers = new HashSet<>(lotto);
        if (lottoIsDuplicate(lottoNumbers, lotto)) {
            throw new IllegalArgumentException(NOT_VALIDATE_LOTTO_MESSAGE);
        }
    }

    private boolean lottoIsDuplicate(Set<LottoNumber> lottoNumbers, List<LottoNumber> lotto) {
        return lottoNumbers.size() != lotto.size();
    }

    private void validateLotto() {
        if (lottoSizeNotValid()) {
            throw new IllegalArgumentException(NOT_VALIDATE_SIZE_LOTTO_MESSAGE);
        }
    }

    private boolean lottoSizeNotValid() {
        return lotto.size() != LOTTO_SIZE;
    }
}
