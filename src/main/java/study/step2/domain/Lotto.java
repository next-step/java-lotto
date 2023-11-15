package study.step2.domain;

import study.step2.domain.dto.WinningNumbers;

public class Lotto {

    private final LottoNumbers lottoNumbers;
    private int numberOfWinnings = 0;

    public Lotto(LottoNumbers lottoNumbers) {
        this.lottoNumbers = lottoNumbers;
    }

    public void match(WinningNumbers winningNumbers) {
        lottoNumbers.lottoNumbers().forEach(lottoNumber -> compare(lottoNumber, winningNumbers));
    }

    private void compare(Integer lottoNumber, WinningNumbers winningNumbers) {
        if (winningNumbers.contains(lottoNumber)) {
            numberOfWinnings += 1;
        }
    }

    public LottoNumbers lottoNumbers() {
        return lottoNumbers;
    }

    public int numberOfWinnings() {
        return numberOfWinnings;
    }

}
