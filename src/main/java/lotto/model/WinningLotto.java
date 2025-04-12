package lotto.model;

public class WinningLotto extends Lotto {

    LottoNumber bonus;

    public WinningLotto(String numbers, String bonus) {
        super(numbers);
        this.bonus = new LottoNumber(Integer.parseInt(bonus));
    }

    public void validate() {
        super.validate();
        if (containsNumber(bonus)) {
            throw new IllegalArgumentException("bonus number is not equal to lotto numbers.");
        }
    }
}
