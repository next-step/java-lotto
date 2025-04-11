package autoLotto;

import java.util.Set;

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

    public LottoPrize getLottoPrize(Lotto lotto) {
        long matched = numbers.stream()
                         .filter(lotto.numbers::contains)
                         .count();
        boolean isBonusNumber = lotto.numbers.contains(bonus) && matched == LottoPrize.SECOND.getMatchedCount();

        return LottoPrize.valueOf(matched, isBonusNumber);
    }

    public boolean containsBonusNumber(LottoNumber number) {
        return bonus == number;
    }
}
