package lotto.service;

import lotto.model.Lottos;
import lotto.utility.LottoNumberGenerator;

import java.util.List;
import java.util.Map;

public class LottoSeller {
    private final Lottos lottos;

    public LottoSeller() {
        lottos = new Lottos();
    }

    public void sellLottos(int lottoCount) {
        for (int count = 1; count <= lottoCount; count++) {
            List<Integer> lotto = LottoNumberGenerator.generateLottoNumber();

            lottos.saveLotto(count, lotto);
        }
    }

    public Map<Integer, List<Integer>> provideLottos() {
        return lottos.provideLottosInfo();
    }
}
