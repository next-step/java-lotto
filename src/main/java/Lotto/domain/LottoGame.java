package Lotto.domain;

import java.util.ArrayList;
import java.util.List;

public class LottoGame {
    private LottoGame() {
    }

    public static LottoGame start() {
        return new LottoGame();
    }

    public LottoList issueLotto(final List<String> manualLottoList, final int maxLottoCount) {
        final List<Lotto> lottoList = new ArrayList<>();
        for (String inputString : manualLottoList) {
            lottoList.add(Lotto.newManualLotto(LottoNumbers.of(inputString)));
        }

        final int autoLottoCount = maxLottoCount - manualLottoList.size();
        for (int i = 0; i < autoLottoCount; i++) {
            lottoList.add(Lotto.newAutoLotto(LottoNumbersGenerator.createNewLotto()));
        }

        return LottoList.of(lottoList);
    }
}
