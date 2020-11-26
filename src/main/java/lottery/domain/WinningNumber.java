package lottery.domain;

import java.util.Collection;
import java.util.List;

public class WinningNumber extends Lottery {
    public static final int COUNT_WINNING_NUMBER = 7;

    private final LotteryNumber bonusNumber;

    public static WinningNumber from(Picker picker) {
        List<LotteryNumber> candidate = picker.pick(COUNT_WINNING_NUMBER);
        return new WinningNumber(candidate.subList(0, candidate.size() - 1), candidate.get(candidate.size() - 1));
    }

    public WinningNumber(Collection<LotteryNumber> numbers, LotteryNumber bonusNumber) {
        super(numbers);
        this.bonusNumber = bonusNumber;
        if(numbers.contains(bonusNumber)) {
            throw new InconsistentLotteryException();
        }
    }

    public int countMatched(Lottery another) {
        return (int) another.getNumbers()
                .stream()
                .filter(getNumbers()::contains)
                .count();
    }
}
