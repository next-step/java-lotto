package lottery.domain;

import static lottery.domain.Lottery.lotteryFactory;

import java.util.Set;

public class WeeklyWinningNumbers {

    private static final String INVALID_BONUS_MSG = "보너스 번호가 로또 번호에 포함되어 있습니다.";

    private final Lottery values;

    private final BonusNumber bonusNumber;

    public WeeklyWinningNumbers(String numberChunk, int bonusNumber) {
        this(lotteryFactory(numberChunk), new BonusNumber(bonusNumber));
    }

    public WeeklyWinningNumbers(Lottery values, BonusNumber bonusNumber) {
        if(values.containsBonus(bonusNumber)) {
            throw new IllegalArgumentException(INVALID_BONUS_MSG);
        }
        this.values = values;
        this.bonusNumber = bonusNumber;
    }

    public int size() {
        return values.size();
    }

    public Set<LotteryNumber> getNumbers() {
        return values.getNumbers();
    }

}
