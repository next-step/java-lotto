package lotto.domain;

public class WinningLotto {

    public WinningLotto(Lotto numbers, LottoNumber bonusNumber) {
        this.numbers = numbers;
        this.bonusNumber = bonusNumber;
    }

    private final Lotto numbers;
    private final LottoNumber bonusNumber;

    public Lotto numbers() {
        return numbers;
    }

    public LottoNumber bonusNumber() {
        return bonusNumber;
    }
}
