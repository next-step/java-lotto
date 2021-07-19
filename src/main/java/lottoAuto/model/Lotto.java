package lottoAuto.model;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class Lotto {
    private static final String CHECK_LOTTO_COUNT_MESSAGE = "로또 번호의 개수는 6개여야 합니다.";
    private static final int LOTTO_NUMBERS_SIZE = 6;

    private Set<LottoNumber> lottoNumbers;

    public Lotto(Set<LottoNumber> lottoNumbers) {
        checkLottoNumbersCount(lottoNumbers.size());
        this.lottoNumbers = new HashSet<>(lottoNumbers);
    }

    public void checkLottoNumbersCount(int lottoNumbersSize) {
        if (lottoNumbersSize != LOTTO_NUMBERS_SIZE) {
            throw new IllegalArgumentException(CHECK_LOTTO_COUNT_MESSAGE);
        }
    }

    public LottoResult makeLottoResult(WinningLotto winningLotto) {
        return new LottoResult(winningLotto.countWinningLottoNumbers(lottoNumbers), winningLotto.hasBonusBall(lottoNumbers));
    }

    public Set<LottoNumber> getLottoNumbers() {
        return Collections.unmodifiableSet(lottoNumbers);
    }
}
