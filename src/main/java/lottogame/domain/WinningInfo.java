package lottogame.domain;

public class WinningInfo {

    private final LottoNumberPackage numbers;
    private final LottoNumber bonusNumber;

    public WinningInfo(LottoNumberPackage numbers, LottoNumber bonusNumber) {
        this.numbers = numbers;
        this.bonusNumber = bonusNumber;
    }

    public LottoNumberPackage getNumbers() {
        return numbers;
    }

    public LottoNumber getBonusNumber() {
        return bonusNumber;
    }
}