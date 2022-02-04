package lotto.domain;

import java.util.List;

public class WinningLotto {

    private static final int BONUS_IDX = 6;
    private static final int WINNING_LOTTO_SIZE = 7;
    private static final String WINNING_LOTTO_SIZE_EXCEPTION_MESSAGE = "[ERROR] 우승 로또 숫자는 보너스 볼 포함 총 7개 입니다";

    private List<LottoNumber> lottoNumbers;

    public WinningLotto(List<LottoNumber> lottoNumbers) {
        this.lottoNumbers = lottoNumbers;
        validateWinningSize();
    }

    public LottoNumber bonusBall() {
        return lottoNumbers.get(BONUS_IDX);
    }

    public int count() {
        return lottoNumbers.size();
    }

    private void validateWinningSize() {
        if (lottoNumbers.size() != WINNING_LOTTO_SIZE) {
            throw new IllegalArgumentException(WINNING_LOTTO_SIZE_EXCEPTION_MESSAGE);
        }
    }
}
