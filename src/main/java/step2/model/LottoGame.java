package step2.model;

import step2.util.LottoRandom;

import java.util.ArrayList;
import java.util.List;

public class LottoGame {
    private static final int LOTTO_COST = 1000;

    private List<Lotto> lottos = new ArrayList<>();

    private int lottoCount;

    public LottoGame(int lottoMoney) {
        lottoCount = lottoMoney / LOTTO_COST;
        LottoRandom lottoRandom = new LottoRandom();

        for (int i = 0; i < lottoCount; i++) {
            lottos.add(new Lotto(lottoRandom.getRandomNumber()));
        }
    }

    public int getLottoCount() {
        return lottoCount;
    }

    public List<Lotto> getLottos() {
        return lottos;
    }
}