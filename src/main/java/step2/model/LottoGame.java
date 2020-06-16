package step2.model;

import step2.util.LottoMakeNumbers;

import java.util.ArrayList;
import java.util.List;

public class LottoGame {

    private Lottos lottos;

    private LottoMoney lottoMoney;

    public LottoGame(LottoMoney lottoMoney) {
        this.lottoMoney = lottoMoney;
        this.lottos = createRandomLotto();
    }

    private Lottos createRandomLotto() {
        List<Lotto> lottoList = new ArrayList<>();
        for (int i = 0; i < lottoMoney.getLottoCount(); i++) {
            lottoList.add(LottoMakeNumbers.getRandomNumber());
        }
        return Lottos.of(lottoList);
    }

    public int getLottoCount() {
        return lottoMoney.getLottoCount();
    }

    public Lottos getLottos() {
        return lottos;
    }
}