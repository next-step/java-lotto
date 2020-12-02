package my.project.lotto.dto;

import my.project.lotto.domain.Lotto;
import my.project.lotto.domain.LottoGenerator;
import my.project.lotto.domain.Money;

import java.util.ArrayList;
import java.util.List;

/**
 * Created : 2020-11-23 오전 11:24
 * Developer : Seo
 */
public class Lottos {
    private final List<Lotto> lottos;

    public Lottos(List<Lotto> lottos) {
        this.lottos = lottos;
    }

    public static Lottos lotto(Money money, ManualLottos manualLottos) {
        List<Lotto> list = new ArrayList<>(manualLottos.getManualLottos());
        for (int i = 0; i < restChances(money, manualLottos); i++) {
            list.add(LottoGenerator.generate());
        }
        return new Lottos(list);
    }

    private static int restChances(Money money, ManualLottos manualLottos) {
        return money.getChances() - manualLottos.size();
    }

    public int size() {
        return this.lottos.size();
    }

    public List<Lotto> getLottos() {
        return this.lottos;
    }

}
