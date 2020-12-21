package lotto.domain;

import java.util.List;
import java.util.stream.Collectors;

public class Lotto {
    public static final int PRICE = 1_000;

    private final LottoNumbers lottoNumbers;

    public Lotto() {
        lottoNumbers = new LottoNumbers();
    }

    public Lotto(LottoNumbers lottoNumbers) {
        this.lottoNumbers = lottoNumbers;
    }

    int countMatchedNumbers(Lotto lotto) {
        return lottoNumbers.countMatchedNumbers(lotto.lottoNumbers);
    }

    boolean isBonus(LottoNumber lottoNumber) {
        return lottoNumbers.isBonusMatched(lottoNumber);
    }

    public List<Integer> getLottoNumbers() {
        return lottoNumbers.getNumbers()
                .stream()
                .map(LottoNumber::getNumber)
                .collect(Collectors.toList());
    }
}
