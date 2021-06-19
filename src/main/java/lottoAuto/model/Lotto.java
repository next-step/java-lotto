package lottoAuto.model;

import java.util.Collections;
import java.util.List;

public class Lotto {
    private static final String CHECK_USER_LOTTO_COUNT_MESSAGE = "로또 번호는 6개여야 합니다.";
    private static final int LOTTO_NUMBERS_SIZE = 6;

    private List<LottoNumber> lottoNumbers;

    public Lotto(List<LottoNumber> lottoNumbers) {
        checkWinningLottoNumbersCount(lottoNumbers.size());
        this.lottoNumbers = lottoNumbers;
    }

    public void checkWinningLottoNumbersCount(int winningLottoNumbersCount) {
        if (winningLottoNumbersCount < LOTTO_NUMBERS_SIZE) {
            throw new IllegalArgumentException(CHECK_USER_LOTTO_COUNT_MESSAGE);
        }
    }

    public int getCorrectCount(List<LottoNumber> winningLottoNumbers) {
        return (int) lottoNumbers.stream()
                .filter(winningLottoNumbers::contains)
                .count()
                ;
    }

    public List<LottoNumber> getLottoNumbers() {
        return Collections.unmodifiableList(lottoNumbers);
    }
}
