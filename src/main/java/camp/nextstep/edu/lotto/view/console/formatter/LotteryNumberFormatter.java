package camp.nextstep.edu.lotto.view.console.formatter;

import camp.nextstep.edu.lotto.domain.LotteryNumber;

public class LotteryNumberFormatter implements Formatter<LotteryNumber> {
    @Override
    public String format(LotteryNumber lotteryNumber) {
        final int value = lotteryNumber.value();
        return String.valueOf(value);
    }
}
