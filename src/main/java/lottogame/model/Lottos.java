package lottogame.model;

import java.util.ArrayList;
import java.util.List;

public class Lottos {

    private List<Lotto> lottos = new ArrayList<>();
    private LottoMachine lottoMachine = new LottoMachine();

    public void purchaseAutoLottoList(int buyCount) {
        for (int i = 0; i < buyCount; i++) {
            lottos.add(lottoMachine.generateAutoLotto());
        }
    }

    public void purchaseManualLottoList(List<String> manualLottoList) {
        for (String manualLottoStr : manualLottoList) {
            lottos.add(lottoMachine.generateManualLotto(manualLottoStr));
        }
    }

    public List<Lotto> getLottos() {
        return lottos;
    }
}
