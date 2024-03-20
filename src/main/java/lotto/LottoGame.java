package lotto;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class LottoGame {
    private final static int LOTTO_PRICE = 1000;
    private List<Lotto> lottos = new ArrayList<>();

    public LottoGame(int lottoCount, LottoGeneration lottoGeneration) {
        for (int i = 0; i < lottoCount; i++) {
            lottos.add(Lotto.create(lottoGeneration));
        }
    }

    public static int LOTTO_PRICE() {
        return LOTTO_PRICE;
    }

    public List<Lotto> getLottos() {
        return this.lottos;
    }
}
