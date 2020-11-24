package lotto.domain;

public class WinningLotto extends Lotto {
    private Number bonus;

    public WinningLotto(Numbers numbers, Number bonus) {
        super(numbers);
        this.bonus = bonus;

        if (checkBonus(numbers)) {
            throw new IllegalArgumentException("bonus number already in winning numbers");
        }
    }

    public boolean checkBonus(Numbers numbers) {
        return numbers.contains(bonus);
    }

    public int countSameNumber(Numbers numbers) {
        return this.getNumbers().countSameNumber(numbers);
    }
}
