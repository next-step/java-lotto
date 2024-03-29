package lotto;

import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;

public class Lotto {
    private static final int LOTTO_SIZE = 6;
    private static final int MIN_LOTTO = 1;
    private static final int MAX_LOTTO = 45;
    private List<Integer> lotto;

    public Lotto(List<Integer> lotto) {
        checkLottoSize(lotto);
        checkDuplicate(lotto);
        checkLottoNumberRange(lotto);

        this.lotto = lotto;
    }

    private void checkLottoNumberRange(List<Integer> lotto) {
        for (int number : lotto) isValidRange(number);
    }

    private void isValidRange(int number) {
        if (number < MIN_LOTTO || number > MAX_LOTTO) {
            throw new IllegalArgumentException("로또는 1~45 사이의 값이어야 합니다.");
        }
    }

    private void checkDuplicate(List<Integer> lotto) {
        if (new HashSet<>(lotto).size() != lotto.size()) {
            throw new IllegalArgumentException("로또에 중복 숫자가 있습니다.");
        }
    }

    private void checkLottoSize(List<Integer> lotto) {
        if (lotto.size() != LOTTO_SIZE) {
            throw new IllegalArgumentException("로또 개수는 6개여야 합니다.");
        }
    }

    @Override
    public String toString() {
        return "[" + String.join(",", lotto.toArray()) + "]";
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) return true;
        if (!(object instanceof Lotto)) return false;
        Lotto lotto1 = (Lotto) object;
        return Objects.equals(lotto, lotto1.lotto);
    }

    @Override
    public int hashCode() {
        return Objects.hash(lotto);
    }
}
