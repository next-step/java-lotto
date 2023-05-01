package lotto.domain;

public class WinningLottoNumbers {

    public WinningLottoNumbers(LottoNumbers numbers, LottoNumber bonusNumber) {
        this.numbers = numbers;
        this.bonusNumber = bonusNumber;
    }

    private final LottoNumbers numbers;
    private final LottoNumber bonusNumber;

    public LottoNumbers numbers() {
        return numbers;
    }

    public LottoNumber bonusNumber() {
        return bonusNumber;
    }
}
