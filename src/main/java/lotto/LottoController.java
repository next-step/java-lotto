package lotto;

import lotto.strategy.RandomDrawLottoNumberStrategy;

import java.util.ArrayList;
import java.util.List;

public class LottoController {
    private final LottoGenerator generator =
            new LottoGenerator(new RandomDrawLottoNumberStrategy());

    public List<LottoPaper> purchaseLotto(Integer lottoCount) {
        List<LottoPaper> purchasedLotto = new ArrayList<>();

        for (int i = 0; i < lottoCount; i++) {
            LottoNumbers lottoNumbers = generator.generateLottoNumber();
            purchasedLotto.add(new LottoPaper(lottoNumbers));
        }

        return purchasedLotto;
    }
}
