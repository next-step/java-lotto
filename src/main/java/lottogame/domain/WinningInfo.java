package lottogame.domain;

public class WinningInfo {

    private final LottoNumberPackage winningNumbers;

    public WinningInfo(LottoNumberPackage winningNumbers) {
        this.winningNumbers = winningNumbers;
    }

    public LottoNumberPackage getWinningNumbers() {
        return winningNumbers;
    }
}