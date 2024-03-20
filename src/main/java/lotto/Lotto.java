package lotto;

import java.util.List;
import java.util.Objects;

public class Lotto {

    private List<Integer> lotto;

    public Lotto(List<Integer> lotto) {
        validEmpty(lotto);
        this.lotto = lotto;
    }

    private void validEmpty(List<Integer> lotto) {
        if (lotto == null || lotto.isEmpty()) {
           throw new IllegalArgumentException("입력값이 없습니다");
        }
    }

    public List<Integer> getLotto() {
        return lotto;
    }

    public int size() {
        return lotto.size();
    }

    public int getFeatNumberCount(Lotto winLotto) {
        return (int) lotto.stream()
                .filter(value -> winLotto.getLotto().contains(value))
                .mapToInt(Integer::intValue)
                .count();
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Lotto lotto1 = (Lotto) o;
        return Objects.equals(lotto, lotto1.lotto);
    }

    @Override
    public int hashCode() {
        return Objects.hash(lotto);
    }
}
