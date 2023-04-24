package study.lotto.domain;

import java.util.ArrayList;
import java.util.List;

public class LottoBundle {

    private List<Lotto> lottos;
    private Integer money;
    private Integer trial;

    public static LottoBundle createLottoBundle(Integer money) {
        LottoBundle lottoBundle = new LottoBundle();
        lottoBundle.setTrial(money / 1000);

        List<Lotto> lottos = new ArrayList<>();

        for (int i = 0; i < lottoBundle.getTrial(); i++) {
            Lotto lotto = Lotto.autoGenerate();
            lottos.add(lotto);
        }

        lottoBundle.setMoney(money);
        lottoBundle.setLottos(lottos);
        return lottoBundle;
    }

    public void setMoney(Integer money) {
        this.money = money;
    }

    public Integer getTrial() {
        return trial;
    }

    public void setTrial(Integer trial) {
        this.trial = trial;
    }

    public List<Lotto> getLottos() {
        return lottos;
    }

    public void setLottos(List<Lotto> lottos) {
        this.lottos = lottos;
    }
}
