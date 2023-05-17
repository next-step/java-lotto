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

    public static LottoBundle createByMoney(Integer money, List<Lotto> manualLottos) {
        List<Lotto> lottos = new ArrayList<>();

        int trial = money / PRICE_PER_SHEET;
        int manualTrial = manualLottos.size();
        if (manualTrial > trial) {
            String message = "%d원으로는 %d장을 구매할 수 없습니다.";
            throw new RuntimeException(String.format(message, money, manualTrial));
        }
        int autoTrial = trial - manualTrial;

        for (int i = 0; i < autoTrial; i++) {
            Lotto lotto = Lotto.autoGenerate();
            lottos.add(lotto);
        }
        for (int i = 0; i < manualTrial; i++) {
            lottos.add(manualLottos.get(i));
        }

        return new LottoBundle(lottos);
    }
}
