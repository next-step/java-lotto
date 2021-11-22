package lotto.model;

import common.model.Number;
import lotto.generator.NumberGenerator;

import java.util.*;

import static lotto.application.Constant.LOTTO_NUMBERS_SIZE;

public class LottoNumbers {

    private final List<LottoNumber> lottoNumbers;
    private LottoRank lottoRank;

    public LottoNumbers(NumberGenerator generator) {
        this.lottoNumbers = autoCreate(generator);
        this.lottoRank = LottoRank.MISS;
        sort();
    }

    public LottoNumbers(List<LottoNumber> lottoNumbers) {
        this.lottoNumbers = lottoNumbers;
        this.lottoRank = LottoRank.MISS;
        sort();
    }

    private List<LottoNumber> autoCreate(NumberGenerator generator) {
        Set<LottoNumber> lottoNumbers = new HashSet<>();
        while (lottoNumbers.size() < LOTTO_NUMBERS_SIZE) {
            lottoNumbers.add(new LottoNumber(generator));
        }
        return new ArrayList<>(lottoNumbers);
    }

    private void sort() {
        lottoNumbers.sort(Comparator.comparingInt(LottoNumber::getNumber));
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
