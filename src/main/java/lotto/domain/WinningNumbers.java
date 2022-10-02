package lotto.domain;


public class WinningNumbers {

    private final Lotto numbers;
    private final LottoNumber bonus;

    public WinningNumbers(String[] numbers, int bonus) {

        this.numbers = new Lotto(numbers);
        this.bonus = new LottoNumber(bonus);

        validateBonus();
    }

    private void validateBonus() {
        if (this.numbers.contain(bonus)) {
            throw new IllegalArgumentException("보너스 번호는 당첨 번호와 중복될 수 없습니다.");
        }
    }

    public int numberOfEquals(Lotto lotto) {
        return numbers.numberOfEquals(lotto);
    }

    public boolean matchBonus(Lotto lotto) {
        return lotto.contain(bonus);
    }

}
