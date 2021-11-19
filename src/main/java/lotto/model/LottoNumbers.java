package lotto.model;

import lotto.generator.NumberGenerator;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class LottoNumbers {

    private final List<LottoNumber> lottoNumbers;

    public LottoNumbers(NumberGenerator generator) {
        this.lottoNumbers = autoCreate(generator);
    }


    private List<LottoNumber> autoCreate(NumberGenerator generator) {
        Set<LottoNumber> lottoNumbers = new HashSet<>();
        while (lottoNumbers.size() < 6) {
            lottoNumbers.add(new LottoNumber(generator));
        }
        return new ArrayList<>(lottoNumbers);
    }

    public List<LottoNumber> getLottoNumbers() {
        return lottoNumbers;
    }
}
