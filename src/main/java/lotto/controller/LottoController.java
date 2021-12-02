package lotto.controller;

import lotto.service.LottoGenerator;
import lotto.service.LottoNumbers;
import lotto.service.LottoPaper;
import lotto.strategy.RandomDrawLottoNumberStrategy;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class LottoController {
    private final LottoGenerator generator =
            new LottoGenerator(new RandomDrawLottoNumberStrategy());

    public List<LottoPaper> purchaseAutoLotto(Integer lottoCount) {
        List<LottoPaper> purchasedLotto = new ArrayList<>();

        for (int i = 0; i < lottoCount; i++) {
            LottoNumbers lottoNumbers = generator.generateLottoNumber();
            purchasedLotto.add(new LottoPaper(lottoNumbers));
        }

        return purchasedLotto;
    }

    public List<LottoPaper> purchaseManualLotto(Set<LottoNumbers> lottoNumbersList) {
        List<LottoPaper> purchasedLotto = new ArrayList<>();

        for (LottoNumbers numbers : lottoNumbersList) {
            purchasedLotto.add(new LottoPaper(numbers));
        }

        return purchasedLotto;
    }
}
