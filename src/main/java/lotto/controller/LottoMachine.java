package lotto.controller;

import lotto.domain.Lotto;
import lotto.domain.LottoNumbers;
import lotto.domain.LottoPrice;
import lotto.util.LottoNumberParser;
import lotto.util.RandomNumbersGenerator;

import java.util.ArrayList;
import java.util.List;

public class LottoMachine {
    private final LottoPrice lottoPrice;

    public LottoMachine(String price) {
        this(new LottoPrice(price));
    }

    public LottoMachine(LottoPrice lottoPrice) {
        this.lottoPrice = lottoPrice;
    }

    public Lotto generate() {
        List<LottoNumbers> lottoNumbersList = new ArrayList<>();

        for (int i = 0; i < lottoPrice.count(); i++) {
            lottoNumbersList.add(new LottoNumbers(LottoNumberParser.parse(RandomNumbersGenerator.randomNumbers())));
        }

        return new Lotto(lottoPrice, lottoNumbersList);
    }
}
