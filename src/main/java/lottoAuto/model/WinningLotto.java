package lottoAuto.model;

import java.util.Collections;
import java.util.List;

public class WinningLotto {
    private static final String CHECK_WINNING_LOTTO_COUNT_MESSAGE = "로또 번호는 6개여야 합니다.";
    private static final int WINNING_LOTTO_NUMBERS_COUNT = 6;

    private List<Integer> winningLottoNumbers;
    private int bonusBall;

    public WinningLotto(List<Integer> winningLottoNumbers, int bonusBall) {
        checkWinningLottoNumbersCount(winningLottoNumbers.size());

        this.winningLottoNumbers = winningLottoNumbers;
        this.bonusBall = bonusBall;
    }

    public void checkWinningLottoNumbersCount(int winningLottoNumbersCount) {
        if (winningLottoNumbersCount < WINNING_LOTTO_NUMBERS_COUNT) {
            throw new IllegalArgumentException(CHECK_WINNING_LOTTO_COUNT_MESSAGE);
        }
    }

    public List<Integer> getWinningLottoNumbers() {
        return Collections.unmodifiableList(winningLottoNumbers);
    }
}
