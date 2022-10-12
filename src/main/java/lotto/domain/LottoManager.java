package lotto.domain;

import java.util.ArrayList;
import java.util.List;
import lotto.strategy.ExtractStrategy;

public class LottoManager {

    private LottoManager() {
    }

    public static LottoBox createLottoBox(int lottoNums, ExtractStrategy extractStrategy) {
        List<Lotto> lottos = new ArrayList<>();
        for (int i = 0; i < lottoNums; i++) {
            Lotto lotto = extractStrategy.extractNumber();
            lottos.add(lotto);
        }
        return new LottoBox(lottos);
    }
}
