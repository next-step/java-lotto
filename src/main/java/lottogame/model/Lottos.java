package lottogame.model;

import java.util.ArrayList;
import java.util.List;

public class Lottos {

    private List<Lotto> lottos = new ArrayList<>();
    private LottoMachine lottoMachine = new LottoMachine();

    public Lottos purchaseAutoLottoList(int buyCount) {
        for (int i = 0; i < buyCount; i++) {
            lottos.add(lottoMachine.generateAutoLotto());
        }
        return this;
    }

    public Lottos purchaseManualLottoList(List<String> manualLottoList) {
        for (String manualLottoStr : manualLottoList) {
            lottos.add(lottoMachine.generateManualLotto(manualLottoStr));
        }
        return this;
    }

    public List<Lotto> getLottos() {
        return lottos;
    }
}
