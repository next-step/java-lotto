package lottoAuto.model;

import java.util.Collections;
import java.util.List;

public class UserLotto {
    private static final String CHECK_USER_LOTTO_COUNT_MESSAGE = "로또 번호는 6개여야 합니다.";
    private static final int USER_LOTTO_NUMBERS_COUNT = 6;

    private List<Integer> lottoNumbers;

    public UserLotto(List<Integer> lottoNumbers) {
        checkWinningLottoNumbersCount(lottoNumbers.size());

        this.lottoNumbers = lottoNumbers;
    }

    public void checkWinningLottoNumbersCount(int winningLottoNumbersCount) {
        if (winningLottoNumbersCount < USER_LOTTO_NUMBERS_COUNT) {
            throw new IllegalArgumentException(CHECK_USER_LOTTO_COUNT_MESSAGE);
        }
    }

    public List<Integer> getLottoNumbers() {
        return Collections.unmodifiableList(lottoNumbers);
    }
}
