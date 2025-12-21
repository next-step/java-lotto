package lotto.controller;

import lotto.domain.Lotto;
import lotto.domain.LottoCount;
import lotto.domain.LottoNumbers;
import lotto.util.LottoNumberParser;
import lotto.util.RandomNumbersGenerator;

import java.util.ArrayList;
import java.util.List;

public class LottoMachine implements LottoGenerator {
    private final LottoCount autoCount;

    public LottoMachine(LottoCount autoCount) {
        this.autoCount = autoCount;
    }

    @Override
    public Lotto generate() {
        List<LottoNumbers> lottoNumbersList = new ArrayList<>();
        for (int i = 0; !autoCount.isCountSame(i); i++) {
            lottoNumbersList.add(new LottoNumbers(LottoNumberParser.parse(RandomNumbersGenerator.randomNumbers())));
        }

        return new Lotto(lottoNumbersList);
    }
}
