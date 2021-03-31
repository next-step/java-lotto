package step2.domain.lotto;

import step2.exception.ListNullPointerException;

import java.util.Objects;
import java.util.Set;

public final class Lottos {

    private final Set<Lotto> lottos;

    private Lottos(Set<Lotto> lottos) {
        validate(lottos);
        this.lottos = lottos;
    }

    public final static Lottos of(Set<Lotto> lottos) {
        return new Lottos(lottos);
    }

    private final void validate(Set<Lotto> lottos) {
        if (Objects.isNull(lottos)) {
            throw new ListNullPointerException();
        }
    }

    public final Set<Lotto> getLottos() {
        return lottos;
    }

    public final int getLottosSize() {
        return lottos.size();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Lottos lottos1 = (Lottos) o;
        return Objects.equals(lottos, lottos1.lottos);
    }

    @Override
    public int hashCode() {
        return Objects.hash(lottos);
    }


}
