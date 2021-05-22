package step2.model;

import java.util.ArrayList;
import java.util.List;
import step2.util.LottoMakeNumbers;

public class LottoGame {

    private Lottos lottos;

    private LottoMoney lottoMoney;

    public LottoGame(LottoMoney lottoMoney) {
        this.lottoMoney = lottoMoney;
        createRandomLotto();
    }

    private void createRandomLotto() {
        List<Lotto> lottoList = new ArrayList<>();
        for (int i = 0; i < lottoMoney.getLottoCount(); i++) {
            lottoList.add(LottoMakeNumbers.getRandomNumber());
        }
        lottos = Lottos.of(lottoList);
    }

    public int getLottoCount() {
        return lottoMoney.getLottoCount();
    }

    public Lottos getLottos() {
        return lottos;
    }
}