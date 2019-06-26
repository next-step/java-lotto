package lotto.domain;

public class BonusNumber extends LottoNumber {
    private Integer number;

    public BonusNumber(Integer number) {
        checkLottoNumberRange(number);
        this.number = number;
    }

    public Integer getNumber() {
        return number;
    }
}
