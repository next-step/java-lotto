package step2.domain.entity;

import step2.domain.vo.LottoPrize;

import java.util.ArrayList;
import java.util.List;

public class Lottos {

    private final List<Lotto> lottos;

    public Lottos(List<Lotto> lottos) {
        this.lottos = lottos;
    }

    public List<Lotto> getLottos() {
        return lottos;
    }

    public int size() {
        return this.lottos.size();
    }

    public LottoRank checkLottoPrize(WinnerLotto winnerLotto) {
        List<LottoPrize> prizes = new ArrayList<>();

        for (Lotto lotto : lottos) {
            final var prize = winnerLotto.prize(lotto);
            prizes.add(prize);
        }

        return new LottoRank(prizes);
    }

    public int getManualLottoQuantity() {
        return (int) this.lottos.stream().filter(Lotto::isManualLotto).count();
    }

    public int getAutoLottoQuantity() {
        return (int) this.lottos.stream().filter(Lotto::isAutoLotto).count();
    }

}
