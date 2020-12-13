package lotto;

import java.util.List;

public class WinningNumber {
    private final List<LottoNumber> winningNumber;

    public WinningNumber(List<LottoNumber> winningNumber) {
        this.winningNumber = winningNumber;
    }

    public boolean contains(LottoNumber lottoNumber) {
        return winningNumber.contains(lottoNumber);
    }
}
