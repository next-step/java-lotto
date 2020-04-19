package Lotto.domain;

import java.util.ArrayList;
import java.util.List;

public class LottoGame {
    private LottoGame() {}

    public static LottoGame start() {
        return new LottoGame();
    }

    public LottoList issueLotto(final int countOfLotto) {
        List<Lotto> lottoList = new ArrayList<>();
        for (int i = 0; i < countOfLotto; i++) {
            lottoList.add(Lotto.of(LottoNumbersGenerator.createNewLotto()));
        }

        return LottoList.of(lottoList);
    }
}
