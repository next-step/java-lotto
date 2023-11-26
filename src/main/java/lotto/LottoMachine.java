package lotto;

import java.util.ArrayList;
import java.util.List;

public class LottoMachine {
    private LottoMachine() {
    }

    public static Lotto makeOne() {
        return Lotto.defaultOf();
    }

    public static Lottos make(int size) {
        List<Lotto> lottos = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            lottos.add(Lotto.defaultOf());
        }
        return Lottos.of(lottos);
    }

    public static Lotto resultIs() {
        return Lotto.defaultOf();
    }

    public static LottoResult match(Lotto result, Lottos lottos) {
        return lottos.countMatching(result);
    }
}
