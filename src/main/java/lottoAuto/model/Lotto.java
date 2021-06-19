package lottoAuto.model;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class Lotto {
    private static final String CHECK_USER_LOTTO_COUNT_MESSAGE = "로또 번호는 6개여야 합니다.";
    private static final int LOTTO_NUMBERS_SIZE = 6;

    private Set<LottoNumber> lottoNumbers;

    public Lotto(Set<LottoNumber> lottoNumbers) {
        checkLottoNumbersCount(lottoNumbers.size());
        this.lottoNumbers = new HashSet<>(lottoNumbers);
    }

    public void checkLottoNumbersCount(int lottoNumbersSize) {
        if (lottoNumbersSize < LOTTO_NUMBERS_SIZE) {
            throw new IllegalArgumentException(CHECK_USER_LOTTO_COUNT_MESSAGE);
        }
    }

    public int getCorrectCount(Set<LottoNumber> winningLottoNumbers) {
        return (int) lottoNumbers.stream()
                .filter(winningLottoNumbers::contains)
                .count()
                ;
    }

    public Set<LottoNumber> getLottoNumbers() {
        return Collections.unmodifiableSet(lottoNumbers);
    }
}
