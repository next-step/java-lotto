package lotto.domain;

import lotto.common.NumberGenerator;

import java.util.List;

public class Lotto {
    private final LottoNumbers lottoNumbers;

    public Lotto(NumberGenerator numberGenerator) {
        this.lottoNumbers = new LottoNumbers(numberGenerator);
    }

    public Lotto(LottoNumbers lottoNumbers) {
        this.lottoNumbers = lottoNumbers;
    }

    public int compareLotto(Lotto lotto) {
        return Math.toIntExact(lottoNumbers.countMatches(lotto.lottoNumbers));
    }

    public boolean contains(LottoNumber bonusNumber) {
        return lottoNumbers.contains(bonusNumber);
    }

    public List<Integer> getLottoNumbers() {
        return lottoNumbers.getLottoNumbers();
    }

}
