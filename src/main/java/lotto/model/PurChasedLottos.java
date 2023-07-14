package lotto.model;

import java.util.ArrayList;
import java.util.List;

public class PurChasedLottos {
    private final List<Lotto> lottos;
    private final LottoMoney lottoMoney;

    public PurChasedLottos(final List<Lotto> lottos, final LottoMoney lottoMoney) {
        this.lottos = lottos;
        this.lottoMoney = lottoMoney;
    }

    public int getLottoCount() {
        return this.lottos.size();
    }

    public List<Lotto> getLottos() {
        return new ArrayList<>(lottos);
    }

    public int getMoney() {
        return lottoMoney.getLottoMoney();
    }
}
