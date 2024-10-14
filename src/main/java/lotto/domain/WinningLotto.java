package lotto.domain;

import java.util.List;
import java.util.Objects;

public class WinningLotto {

    private final Lotto lotto;

    public WinningLotto(Lotto lotto) {
        this.lotto = lotto;
    }

    public WinningLotto(int... numbers) {
        this(new Lotto(numbers));
    }

    public WinningLotto(List<Integer> numbers) {
        this(new Lotto(numbers));
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        WinningLotto that = (WinningLotto) o;
        return Objects.equals(lotto, that.lotto);
    }

    @Override
    public int hashCode() {
        return Objects.hash(lotto);
    }
}
