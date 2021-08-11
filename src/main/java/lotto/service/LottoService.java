package lotto.service;

import lotto.domain.Lotto;
import lotto.domain.LottoGenerator;
import lotto.domain.Lottos;

public class LottoService {
    public Lottos execute(int count, LottoGenerator lottoGenerator) {
        Lottos lottos = new Lottos();
        for (int i = 0; i < count; i++) {
            Lotto lotto = lottoGenerator.generate();
            lottos.add(lotto);
        }
        return lottos;
    }
}
