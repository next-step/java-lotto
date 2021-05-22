package lotto.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class LottoNumbersGenerator {
    private List<LottoNumber> lottoNumbers = new ArrayList<>();

    public LottoNumbersGenerator() {
        for (int i = LottoNumber.LOTTO_NUMBER_MIN; i <= LottoNumber.LOTTO_NUMBER_MAX; i++) {
             lottoNumbers.add(new LottoNumber(i));
        }
    }

    public LottoNumbersGenerator(List<LottoNumber> lottoNumbers) {
        this.lottoNumbers = new ArrayList<>(lottoNumbers);
    }

    public List<LottoNumber> generateRandomLottoNumbers() {
        Collections.shuffle(this.lottoNumbers);
        return this.lottoNumbers.stream()
                .limit(Lotto.LOTTO_NUMBERS_COUNT)
                .sorted()
                .collect(Collectors.toList());
    }
}
