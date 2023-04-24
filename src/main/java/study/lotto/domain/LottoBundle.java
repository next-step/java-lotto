package study.lotto.domain;

import java.util.ArrayList;
import java.util.List;

public class LottoBundle {

    private List<Lotto> lottos;

    public static LottoBundle createLottoBundle(Integer money) {
        LottoBundle lottoBundle = new LottoBundle();
        int trial = money / 1000;

        List<Lotto> lottos = new ArrayList<>();

        for (int i = 0; i < trial; i++) {
            Lotto lotto = Lotto.autoGenerate();
            lottos.add(lotto);
        }

        lottoBundle.setLottos(lottos);
        return lottoBundle;
    }

    public List<Lotto> getLottos() {
        return lottos;
    }

    public void setLottos(List<Lotto> lottos) {
        this.lottos = lottos;
    }
}
