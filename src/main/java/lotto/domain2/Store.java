package lotto.domain2;

import java.util.Objects;

public class Store {
    private final LottoMachine lottoMachine;

    public Store(final LottoMachine lottoMachine) {
        this.lottoMachine = lottoMachine;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Store store = (Store) o;
        return Objects.equals(lottoMachine, store.lottoMachine);
    }

    @Override
    public int hashCode() {
        return Objects.hash(lottoMachine);
    }
}
