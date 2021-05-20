package lotto.domain;

import java.util.HashSet;
import java.util.Set;

public class LottoGame {
    private static final int LOTTO_NUMBER_COUNT = 6;

    private Set<LottoNumber> lottoNumbers = new HashSet<>();

    public LottoGame() {
        while(lottoNumbers.size() < LOTTO_NUMBER_COUNT) {
            lottoNumbers.add(new LottoNumber(new RandomNumber()));
        }
    }

    public LottoGame(Set<LottoNumber> lottoNumbers) {
        this.lottoNumbers = lottoNumbers;
    }

    public boolean isValid() {
        return this.lottoNumbers.size() == LOTTO_NUMBER_COUNT;
    }
}
