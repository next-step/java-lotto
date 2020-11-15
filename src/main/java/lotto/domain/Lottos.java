package lotto.domain;

import java.util.LinkedList;
import java.util.List;
import java.util.Objects;
import java.util.function.Supplier;

public class Lottos {
    private final List<Lotto> lottos;

    public Lottos(int size, Supplier<Lotto> supplier) {
        lottos = new LinkedList<>();
        for (int i = 0; i < size; i++) {
            lottos.add(supplier.get());
        }
    }

    public Result getResult(Lotto winningLotto) {
        return new Result(lottos, winningLotto);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (Lotto lotto : lottos) {
            sb.append(lotto + "\n");
        }
        return sb.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Lottos lottos1 = (Lottos) o;
        return Objects.equals(lottos.toString(), lottos1.lottos.toString());
    }

    @Override
    public int hashCode() {
        return Objects.hash(lottos.toString());
    }
}
