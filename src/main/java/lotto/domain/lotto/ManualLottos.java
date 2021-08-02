package lotto.domain.lotto;

import java.util.List;
import java.util.Objects;

public class ManualLottos extends Lottos {

    protected ManualLottos(List<Lotto> lottos) {
        super(lottos);
    }

    public static ManualLottos of(List<Lotto> lottos) {
        return new ManualLottos(lottos);
    }

    @Override
    protected void validate(List<Lotto> lottos) {
        if (Objects.isNull(lottos)) {
            throw new IllegalStateException("lotto 리스트는 null이면 안됩니다");
        }
    }
}
