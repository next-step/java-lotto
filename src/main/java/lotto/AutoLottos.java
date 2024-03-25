package lotto;

import java.util.List;

public class AutoLottos {

    private final List<Lotto> lottos;

    public AutoLottos(AutoCount count) {
        this(count.buyLottos());
    }

    public AutoLottos(List<Lotto> lottos) {
        this.lottos = lottos;
    }

    public LottoGame merge(ManualLottos manualLottos) {
        return new LottoGame(manualLottos.add(this.lottos));
    }
}
