package model;

public class LottoWinningNumber {

    private final WinningNumbers winningNumbers;
    private final LottoNumber lottoNumber;

    public LottoWinningNumber(final WinningNumbers winningNumbers, final LottoNumber lottoNumber) {
        validate(winningNumbers, lottoNumber);
        this.winningNumbers = winningNumbers;
        this.lottoNumber = lottoNumber;
    }

    private void validate(final WinningNumbers winningNumbers, final LottoNumber lottoNumber) {
        if (winningNumbers.contains(lottoNumber)) {
            throw new IllegalArgumentException("보너스 번호는 당첨 번호와 같으면 안 됩니다.");
        }
    }

    public WinningNumbers getWinningNumbers() {
        return winningNumbers;
    }

    public LottoNumber getLottoNumber() {
        return lottoNumber;
    }
}
