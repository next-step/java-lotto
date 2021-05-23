package lotto.domain;

import java.util.ArrayList;
import java.util.List;


public class AutoLottoNumbersGenerator implements LottoNumbersGenerator{

    private final NumbersGenerator lottoNumbersGenerator;
    private final int autoCount;

    public AutoLottoNumbersGenerator(int autoCount, NumbersGenerator lottoNumbersGenerator) {
        this.autoCount = autoCount;
        this.lottoNumbersGenerator = lottoNumbersGenerator;

    }

    public List<LottoNumbers> generate() {
        List<LottoNumbers> lottoNumbersList = new ArrayList<>();
        for (int i = 0; i < autoCount; i++) {
            lottoNumbersList.add(LottoNumbers.of(lottoNumbersGenerator.generate()));
        }
        return lottoNumbersList;
    }
}
