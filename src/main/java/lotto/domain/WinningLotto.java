package lotto.domain;

public class WinningLotto {

    private final Lotto numbers;
    private final LottoNumber bonusBall;

    private WinningLotto(Lotto numbers, LottoNumber bonusBall) {
        this.numbers = numbers;
        this.bonusBall = bonusBall;
    }

    public static WinningLotto of(String number, int bonusBall) {
        return new WinningLotto(Lotto.of(number), LottoNumber.of(bonusBall));
    }

    public Lotto getNumbers() {
        return numbers;
    }

    public LottoNumber getBonusBall() {
        return bonusBall;
    }
}
