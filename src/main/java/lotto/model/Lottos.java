package lotto.model;

import lotto.exception.LottoCountException;

import java.util.List;
import java.util.Objects;

public final class Lottos {
    private final List<Lotto> lottos;
    private final int inputCount;

    public Lottos(List<Lotto> lottos, int inputCount) {
        validate(lottos, inputCount);
        this.lottos = lottos;
        this.inputCount = inputCount;
    }

    public static Lottos plus(Lottos manualLottos, Lottos autoLottos) {
        manualLottos.lottos.addAll(autoLottos.lottos);
        return new Lottos(manualLottos.lottos, manualLottos.lottos.size());
    }

    private void validate(List<Lotto> lottos, int inputCount) {
        if (lottos.size() != inputCount) {
            throw new LottoCountException(inputCount);
        }
    }

    public List<Lotto> getLottos() {
        return this.lottos;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Lottos lottos1 = (Lottos) o;
        return inputCount == lottos1.inputCount && Objects.equals(lottos, lottos1.lottos);
    }

    @Override
    public int hashCode() {
        return Objects.hash(lottos, inputCount);
    }
}
