package lotto;


import lotto.domain.Lotto;
import lotto.domain.LottoPurchase;
import lotto.domain.Lottos;

import java.util.List;

/**
 * @author : 김윤호
 * @version : 1.0
 * @date : 2019-11-02 22:36
 */
public class LottoMachine {

    private LottoPurchase lottoPurchase;
    private final Lottos lottos;

    public LottoMachine(LottoPurchase lottoPurchase, List<String> manualLottoNumbers) {
        this.lottoPurchase = lottoPurchase;
        this.lottos = new Lottos(lottoPurchase, manualLottoNumbers);
    }

    public List<Lotto> getLottos() {
        return this.lottos.getLottoNumbers();
    }

    public int getAutoLottoCount() {
        return this.lottoPurchase.getAutoLottoCount();
    }

    public int getManualLottoCount() {
        return this.lottoPurchase.getManualLottoCount();
    }
}
