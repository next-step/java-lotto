package lotto;

import java.util.ArrayList;
import java.util.List;

public class LottoMachine {
    private LottoMachine() {
    }

    public static List<Lotto> buyWith(int amount) {
        int lottoSize = amount / Lotto.PRICE;
        List<Lotto> lottos = new ArrayList<>();
        for (int i = lottoSize; i > 0; i--) {
            lottos.add(new Lotto());
        }
        return lottos;
    }
}
