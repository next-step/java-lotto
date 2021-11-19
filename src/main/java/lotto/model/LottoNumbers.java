package lotto.model;

import common.model.Number;
import lotto.generator.NumberGenerator;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class LottoNumbers {

    private final List<LottoNumber> lottoNumbers;
    private LottoRank lottoRank;

    public LottoNumbers(NumberGenerator generator) {
        this.lottoNumbers = autoCreate(generator);
        this.lottoRank = LottoRank.MISS;
    }

    public LottoNumbers(List<LottoNumber> lottoNumbers) {
        this.lottoNumbers = lottoNumbers;
        this.lottoRank = LottoRank.MISS;
    }

    private List<LottoNumber> autoCreate(NumberGenerator generator) {
        Set<LottoNumber> lottoNumbers = new HashSet<>();
        while (lottoNumbers.size() < 6) {
            lottoNumbers.add(new LottoNumber(generator));
        }
        return new ArrayList<>(lottoNumbers);
    }

    public void matchRank(Number matchCount) {
        this.lottoRank = LottoRank.valueOf(matchCount.getNumber());
    }

    public List<LottoNumber> getLottoNumbers() {
        return this.lottoNumbers;
    }

    public LottoRank getLottoRank() {
        return lottoRank;
    }
}
