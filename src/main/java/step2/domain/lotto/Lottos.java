package step2.domain.lotto;

import step2.exception.ListNullPointerException;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public final class Lottos {

    private final List<Lotto> lottos;

    private Lottos(List<Lotto> lottos) {
        this.lottos = lottos;
    }

    public final static Lottos newInstance() {
        return new Lottos(new ArrayList<>());
    }

    public final static Lottos newInstance(List<Lotto> lottos) {
        validate(lottos);
        return new Lottos(lottos);
    }

    private static final void validate(List<Lotto> lottos) {
        if(Objects.isNull(lottos)){
            throw new ListNullPointerException();
        }
    }

    public final void add(Lotto additionalLotto) {
        lottos.add(additionalLotto);
    }

    public final List<Lotto> getLottos() {
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
