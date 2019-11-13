package lotto.domain;

import java.util.List;
import java.util.Set;

public class Lotto {

    private final LottoNumbers lottoNumbers;

    public Lotto(LottoNumbers lottoNumbers) {
        this.lottoNumbers = lottoNumbers;
    }

    public LottoNumbers getLottoNumbers() {
        return lottoNumbers;
    }

    public long getMatchNumberCount(Lotto targetLotto) {
        return targetLotto
                .getNumbers()
                .stream()
                .filter(lottoNumbers::contains)
                .count();
    }

    protected Set<LottoNumber> getNumbers() {
        return lottoNumbers.getValue();
    }

}
