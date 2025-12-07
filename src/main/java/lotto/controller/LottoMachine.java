package lotto.controller;

import lotto.domain.Lotto;
import lotto.domain.LottoNumbers;
import lotto.domain.LottoPrice;
import lotto.util.RandomNumbersGenerator;

import java.util.ArrayList;
import java.util.List;

public class LottoMachine {
    private LottoPrice lottoPrice;

    public LottoMachine(String price) {
        this(new LottoPrice(price));
    }

    public LottoMachine(LottoPrice lottoPrice) {
        this.lottoPrice = lottoPrice;
    }

    public Lotto generate() {
        List<LottoNumbers> lottoNumbersList = new ArrayList<>();

        for (int i = 0; i < lottoPrice.count(); i++) {
            lottoNumbersList.add(new LottoNumbers(RandomNumbersGenerator.randomNumbers()));
        }

        return new Lotto(lottoPrice, lottoNumbersList);
    }
}
