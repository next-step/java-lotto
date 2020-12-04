package lotto.domain;

import lotto.util.LottoGenerator;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Stream;

public class Lotto {
    private static final int LOTTO_COMPOSITION_NUMBER = 6;

    private List<LottoNumber> lottoNumbers;

    public Lotto(LottoGenerator generator) {
        this.lottoNumbers = new ArrayList<>();
        initLotto(generator);
    }

    private void initLotto(LottoGenerator generator) {
        while (lottoNumbers.size() < LOTTO_COMPOSITION_NUMBER) {
            initSingleLottoNumber(generator);
        }
        Collections.sort(lottoNumbers);
    }

    private void initSingleLottoNumber(LottoGenerator generator) {
        LottoNumber lottoNumber = new LottoNumber(generator.generatorNumber());
        if (lottoNumbers.contains(lottoNumber)) {
            return;
        }
        lottoNumbers.add(lottoNumber);
    }

    public int getCountByMatch(Lotto lotto) {
        return (int) lottoNumbers.stream()
                .filter(lotto.lottoNumbers::contains)
                .count();
    }

    public boolean isBonus(LottoNumber lottoNumber) {
        return getLottoNumberByMatch(lottoNumber)
                .count() > 0;
    }

    private Stream<LottoNumber> getLottoNumberByMatch(LottoNumber lottoNumber) {
        return lottoNumbers.stream()
                .filter(lottoNumber::equals);
    }

    @Override
    public String toString() {
        return String.valueOf(lottoNumbers);
    }
}
