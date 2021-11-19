package lotto.model;

import common.model.Number;
import lotto.generator.NumberGenerator;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class LottoNumbers {

    private final List<LottoNumber> lottoNumbers;
    private final Number matchCount;

    public LottoNumbers(NumberGenerator generator) {
        this.lottoNumbers = autoCreate(generator);
        this.matchCount = new Number();
    }

    public LottoNumbers(List<LottoNumber> lottoNumbers) {
        this.lottoNumbers = lottoNumbers;
        this.matchCount = new Number();
    }

    private List<LottoNumber> autoCreate(NumberGenerator generator) {
        Set<LottoNumber> lottoNumbers = new HashSet<>();
        while (lottoNumbers.size() < 6) {
            lottoNumbers.add(new LottoNumber(generator));
        }
        return new ArrayList<>(lottoNumbers);
    }

    public void match(LottoNumbers matchNumbers) {
        for (LottoNumber lottoNumber : this.lottoNumbers) {
            matchNumbers.match(lottoNumber);
        }
    }

    public void match(LottoNumber matchNumber) {
        if (contains(matchNumber)) {
            this.matchCount.plus();
        }
    }

    public boolean contains(LottoNumber lottoNumber) {
        return this.lottoNumbers.contains(lottoNumber);
    }

    public List<LottoNumber> getLottoNumbers() {
        return this.lottoNumbers;
    }

    public Number getMatchCount() {
        return matchCount;
    }
}
