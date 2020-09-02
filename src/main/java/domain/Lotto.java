package domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class Lotto {
    private static final int LAST_NUMBER = 45;
    private static final int SIX = 6;
    private static final int ONE = 1;

    private Set<Integer> lottoNumber;

    public Lotto(Set<Integer> lotto) {
        validateLottoNumber(lotto);
        this.lottoNumber = lotto;
    }

    private void validateLottoNumber(Set<Integer> lotto) {
        validateEmpty(lotto);
        validateSize(lotto);
        validateNumberRange(lotto);
    }

    private void validateEmpty(Set<Integer> lotto) {
        if (lotto.size() == 0 || lotto == null) {
            throw new IllegalArgumentException("empty!");
        }
    }

    private void validateSize(Set<Integer> lotto) {
        if (lotto.size() != SIX) {
            throw new IllegalArgumentException("not 6 number");
        }
    }

    public List<Integer> getLottoNumber() {
        return new ArrayList<>(lottoNumber);
    }

    private void validateNumberRange(Set<Integer> lotto) {
        boolean rangeValidate = lotto.stream()
                .allMatch(c -> c <= LAST_NUMBER && c >= ONE);

        if (!rangeValidate) {
            throw new IllegalArgumentException("숫자 45내 범위 입력 오류!!");
        }
    }
}
