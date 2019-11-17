package lotto;


import lotto.domain.Lotto;
import lotto.domain.LottoAmount;
import lotto.domain.LottoGenerator;

import java.util.ArrayList;
import java.util.List;

/**
 * @author : 김윤호
 * @version : 1.0
 * @date : 2019-11-02 22:36
 */
public class LottoMachine {

    private LottoAmount lottoAmount;
    private final List<Lotto> lottos;

    public LottoMachine(LottoAmount lottoAmount) {
        this.lottoAmount = lottoAmount;
        this.lottos = new ArrayList<>();
    }

    private void purchaseAutoLotto(LottoGenerator lottoGenerator) {
        while (!lottoAmount.isEndAutoLotto()) {
            this.lottoAmount = lottoAmount.decrease();
            lottos.add(Lotto.of(lottoGenerator.generate()));
        }
    }

    private void purchaseManualLotto(List<String> manualLottoNumbers) {
        for (String lottoNumber : manualLottoNumbers) {
            lottos.add(Lotto.ofWinningLotto(lottoNumber));
        }
    }

    public List<Lotto> getLottos() {
        return this.lottos;
    }

    public int getAutoLottoCount() {
        return this.lottoAmount.getAutoLottoCount();
    }

    public int getManualLottoCount() {
        return this.lottoAmount.getManualLottoCount();
    }

    public void purchaseLotto(LottoGenerator lottoGenerator, List<String> manualLottoNumbers) {
        purchaseAutoLotto(lottoGenerator);

        if (manualLottoNumbers.size() > 0) {
            purchaseManualLotto(manualLottoNumbers);
        }
    }
}
