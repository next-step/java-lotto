package lotto.domain;

public class BonusNumber extends LottoNumber {

    public BonusNumber(int value) {
        super(value);
    }

    public boolean isSameNumber(final LottoNumber number) {
        return this.getValue() == number.getValue();
    }
}
