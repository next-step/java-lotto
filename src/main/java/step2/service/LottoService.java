package step2.service;

import step2.domain.Lotto;
import step2.domain.LottoStore;

import java.util.List;

public class LottoService {

    private LottoStore lottoStore;

    public LottoService () {
        this.lottoStore = new LottoStore();
    }

    public List<Lotto> buyLotto(int fee) {
        return this.lottoStore.buy(fee);
    }

    public void initWinNumbers(String winNumberString) {
        this.lottoStore.initWinNumbers(winNumberString);
    }

    public List<Long> findLottoResult() {
        return this.lottoStore.findWinLottoMoney();
    }
}
