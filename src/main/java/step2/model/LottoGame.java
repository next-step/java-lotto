package step2.model;

import step2.util.LottoRandomNumbers;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LottoGame {

    private List<Lotto> lottos = new ArrayList<>();

    private LottoMoney lottoMoney;

    public LottoGame(int inputMoney) {
        lottoMoney = new LottoMoney(inputMoney);
        createRandomLotto();
    }

    private void createRandomLotto() {
        for (int i = 0; i < lottoMoney.getLottoCount(); i++) {
            lottos.add(LottoRandomNumbers.getRandomNumber());
        }
    }

    public int getLottoCount() {
        return lottoMoney.getLottoCount();
    }

    public List<Lotto> getLottos() {
        return Collections.unmodifiableList(lottos);
    }
}