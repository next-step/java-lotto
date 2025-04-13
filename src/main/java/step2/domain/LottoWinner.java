package step2.domain;

import java.util.List;

/**
 * 당첨 로또 클래스
 */
public class LottoWinner {
    private final LottoNumbers lottoNumbers;

    public LottoWinner(LottoNumbers lottoNumbers) {
        this.lottoNumbers = lottoNumbers;
    }

    public List<Integer> getWinningNumbers() {
        return lottoNumbers.getNumbers();
    }
}
