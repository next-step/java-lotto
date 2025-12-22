package lotto.controller;

import lotto.domain.Lotto;
import lotto.domain.LottoNumbers;
import lotto.util.LottoNumberParser;

import java.util.ArrayList;
import java.util.List;

public class ManualLottoMachine implements LottoGenerator {
    private final List<String> lottoNumbersList;
    public ManualLottoMachine(List<String> manualLottoNumbers) {
        this.lottoNumbersList = manualLottoNumbers;
    }

    @Override
    public Lotto generate() {
        List<LottoNumbers> lottoNumbersList = new ArrayList<>();

        for (int i = 0; i < this.lottoNumbersList.size(); i++) {
            lottoNumbersList.add(new LottoNumbers(LottoNumberParser.parse(this.lottoNumbersList.get(i))));
        }

        return new Lotto(lottoNumbersList);
    }
}
