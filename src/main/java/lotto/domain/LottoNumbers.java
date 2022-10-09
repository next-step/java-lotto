package lotto.domain;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;

import lotto.domain.strategy.NumberGenerateStrategy;

public class LottoNumbers implements Iterable<LottoNumber> {
    private final List<LottoNumber> lottoNumbers;

    public LottoNumbers(List<LottoNumber> lottoNumbers) {
        this.lottoNumbers = lottoNumbers;
    }
    
    public LottoNumbers match(LottoNumber luckyLottoNumber, int matchCount) {
        List<LottoNumber> matchLottoNumbers = new ArrayList<>();
        for (LottoNumber lottoNumber : lottoNumbers) {
            addMatchNumber(luckyLottoNumber, matchCount, matchLottoNumbers, lottoNumber);
        }
        return new LottoNumbers(matchLottoNumbers);
    }

    private void addMatchNumber(LottoNumber luckyLottoNumber, int matchCount, List<LottoNumber> matchLottoNumbers, LottoNumber lottoNumber) {
        if (lottoNumber.matchCount(luckyLottoNumber) == matchCount) {
            matchLottoNumbers.add(lottoNumber);
        }
    }

    public int count() {
        return lottoNumbers == null ? 0 : lottoNumbers.size();
    }
    
    public static LottoNumbers of(NumberGenerateStrategy method, int lottoCount) {
        List<LottoNumber> lottoNumbers = new ArrayList<>();
        for (int count = 0; count < lottoCount; count++) {
            lottoNumbers.add(number(method));
        }
        return new LottoNumbers(lottoNumbers);
    }
    
    private static LottoNumber number(NumberGenerateStrategy method) {
        return new LottoNumber(method.createNumbers());
    }

    @Override
    public Iterator<LottoNumber> iterator() {
        return lottoNumbers.iterator();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {return true;}
        if (o == null || getClass() != o.getClass()) {return false;}
        LottoNumbers numbers1 = (LottoNumbers) o;
        return lottoNumbers.containsAll(numbers1.lottoNumbers) && numbers1.lottoNumbers.containsAll(lottoNumbers);
    }

    @Override
    public int hashCode() {
        return Objects.hash(lottoNumbers);
    }
}
