package step2.model;

import step2.util.LottoRandomNumbers;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LottoGame {
    private static final int LOTTO_COST = 1000;

    private List<Lotto> lottos = new ArrayList<>();

    private int lottoCount;

    public LottoGame(int lottoMoney) {
        lottoCount = lottoMoney / LOTTO_COST;
        createRandomLotto();
    }

    private void createRandomLotto() {
        for (int i = 0; i < lottoCount; i++) {
            lottos.add(LottoRandomNumbers.getRandomNumber());
        }
    }

    public int getLottoCount() {
        return lottoCount;
    }

    public List<Lotto> getLottos() {
        return Collections.unmodifiableList(lottos);
    }
}