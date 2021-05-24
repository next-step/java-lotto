package lotto.domain;

import java.util.List;


public class AutoLottoNumbersGenerator {

    private final NumbersGenerator lottoNumbersGenerator;

    public AutoLottoNumbersGenerator(NumbersGenerator lottoNumbersGenerator) {
        this.lottoNumbersGenerator = lottoNumbersGenerator;

    }

    public List<LottoNumbers> generate(int count) {
        return lottoNumbersGenerator.generate(count);
    }
}
