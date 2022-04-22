package lotto.domain;

import lotto.exception.InvalidLottoLengthException;

import java.util.*;

public class Lotto {
    private static final int VALID_LOTTO_LENGTH = 6;
    private final Set<Integer> lotto;

    Lotto(List<Integer> lotto) {
        validateLotto(lotto);
        this.lotto = new HashSet<>(lotto);
    }

    private void validateLotto(List<Integer> lotto) {
        if (VALID_LOTTO_LENGTH != lotto.size()) {
            throw new InvalidLottoLengthException(lotto.size());
        }
    }

    public Lotto(Integer[] lotto) {
        this.lotto = new HashSet<>(Arrays.asList(lotto));
    }

    public Set<Integer> getLottoNumbers() {
        return new TreeSet<>(lotto);
    }

    public int countDuplicateValue(Lotto lotto) {
        Set<Integer> copyOfLotto = new HashSet<>(this.lotto);
        copyOfLotto.retainAll(lotto.getLottoNumbers());

        return copyOfLotto.size();
    }
}
