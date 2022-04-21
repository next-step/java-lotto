package lotto.domain;

import lotto.exception.InvalidLottoLengthException;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Lotto {
    public static final int VALID_LOTTO_LENGTH = 6;
    private final List<Integer> lotto;

    Lotto(List<Integer> lotto) {
        validateLotto(lotto);
        this.lotto = new ArrayList<>(lotto);
    }

    private void validateLotto(List<Integer> lotto) {
        if (VALID_LOTTO_LENGTH != lotto.size()) {
            throw new InvalidLottoLengthException(lotto.size());
        }
    }

    public List<Integer> getLottoNumbers() {
        return Collections.unmodifiableList(lotto);
    }
}
