package lotto.domain;

import java.util.List;
import java.util.Objects;

public class Lotto {
    List<Integer> lotto;

    public Lotto(List<Integer> lotto) {
        this.lotto = lotto;
    }

    public String lottoNumber() {
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        for (int i = 0; i < lotto.size(); i++) {
            sb.append(lotto.get(i));
            numberDelimiter(i, sb);
        }
        sb.append("]");
        return sb.toString();
    }

    private void numberDelimiter(int i, StringBuilder sb) {
        if (i < lotto.size()-1) {
            sb.append(", ");
        }
    }

    @Override
    public final boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Lotto)) return false;

        Lotto lotto1 = (Lotto) o;
        return Objects.equals(lotto, lotto1.lotto);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(lotto);
    }
}
