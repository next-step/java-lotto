package lotto.domain;


import java.util.ArrayList;
import java.util.List;

public class LottoMachine {
    private LottoMachine() {
    }

    public static Lottos buyWith(int amount) {
        int lottoSize = amount / Lotto.PRICE;
        List<Lotto> lottos = new ArrayList<>();
        for (int i = lottoSize; i > 0; i--) {
            lottos.add(LottoGenerator.getLotto());
        }
        return new Lottos(lottos);
    }
}
