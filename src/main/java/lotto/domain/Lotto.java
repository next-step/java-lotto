package lotto.domain;

import static lotto.common.SystemMessage.*;

import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import lotto.common.exception.LottoException;

public class Lotto {

    private static final int LOTTO_SIZE = 6;

    private final List<LottoNumber> lotto;

    public Lotto(final List<LottoNumber> lotto) {
        validateNumbersSize(lotto);
        validateDuplicateNumber(lotto);
        this.lotto = lotto;
    }

    public Lotto() {
        this(LottoAutoGenerator.getInstance().generateLotto());
    }

    private void validateDuplicateNumber(final List<LottoNumber> lotto) {
        Set<LottoNumber> lottoDuplicate = new HashSet<>(lotto);
        if (lotto.size() != lottoDuplicate.size()) {
            throw new LottoException(DUPLICATE_EXCEPTION_MESSAGE);
        }
    }

    private void validateNumbersSize(final List<LottoNumber> lotto) {
        if (lotto.size() != LOTTO_SIZE) {
            throw new LottoException(LOTTO_SIZE_EXCEPTION_MESSAGE);
        }
    }

    public List<LottoNumber> getLotto() {
        return Collections.unmodifiableList(lotto);
    }
}
