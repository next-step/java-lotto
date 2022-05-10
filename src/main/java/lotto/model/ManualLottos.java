package lotto.model;

import lotto.exception.ManualLottoSizeException;
import lotto.util.AwardNumberUtil;

import java.util.List;
import java.util.Objects;
import java.util.Set;

public final class ManualLottos {
    private final int manualLottoCount;
    private final List<Lotto> lottos;

    public ManualLottos(Set<Integer>... lottos) {
        this(lottos.length, AwardNumberUtil.convertLotto(lottos));
    }

    public ManualLottos(int manualLottoCount, List<Lotto> lottos) {
        validate(lottos.size(), manualLottoCount);
        this.manualLottoCount = manualLottoCount;
        this.lottos = lottos;
    }

    private void validate(int manualLottoCount, int lottoSize) {
        if (lottoSize != manualLottoCount) {
            throw new ManualLottoSizeException(manualLottoCount);
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ManualLottos that = (ManualLottos) o;
        return Objects.equals(lottos, that.lottos);
    }

    @Override
    public int hashCode() {
        return Objects.hash(lottos);
    }
}
