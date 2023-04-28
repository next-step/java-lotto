package study.lotto.domain;

import java.util.ArrayList;
import java.util.List;

public class LottoBundle {
    public static final int PRICE_PER_SHEET = 1000;

    private List<Lotto> lottos;

    public LottoBundle(List<Lotto> lottos) {
        this.lottos = lottos;
    }

    public List<Lotto> getLottos() {
        return lottos;
    }

    public static LottoBundle createByMoney(Integer money) {
        int trial = money / PRICE_PER_SHEET;

        List<Lotto> lottos = new ArrayList<>();

        for (int i = 0; i < trial; i++) {
            Lotto lotto = Lotto.autoGenerate();
            lottos.add(lotto);
        }

        return new LottoBundle(lottos);
    }
}
