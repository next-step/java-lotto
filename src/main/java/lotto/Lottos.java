package lotto;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Lottos {
    private final List<Lotto> values;

    public Lottos(List<Lotto> lottos) {
        this.values = lottos;
    }

    public Lottos(int quantity) {
        List<Lotto> lottos = new ArrayList<>();

        for (int i = 0; i < quantity; i++) {
            Lotto lotto = new Lotto();
            lottos.add(lotto);
        }

        this.values = lottos;
    }

    public long result(LottoNumbers winningNumbers, Condition condition) {
        return values.stream()
                .filter(lotto -> lotto.result(winningNumbers, condition))
                .count();
    }

    public List<Lotto> getValues() {
        return values;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Lottos lottos = (Lottos) o;
        return Objects.equals(values, lottos.values);
    }

    @Override
    public int hashCode() {
        return Objects.hash(values);
    }

    @Override
    public String toString() {
        return "Lottos{" +
                "values=" + values +
                '}';
    }
}
