package camp.nextstep.edu.lotto.view.console.formatter;

import camp.nextstep.edu.lotto.domain.Lottery;
import camp.nextstep.edu.lotto.domain.LotteryNumber;

import java.util.stream.Collectors;

public class LotteryFormatter implements Formatter<Lottery> {
    private static final String PREFIX = "[";
    private static final String POSTFIX = "]";
    private static final String DELIMITER = ", ";

    private final Formatter<LotteryNumber> lotteryNumberFormatter;

    public LotteryFormatter(Formatter<LotteryNumber> lotteryNumberFormatter) {
        this.lotteryNumberFormatter = lotteryNumberFormatter;
    }

    @Override
    public String format(Lottery lottery) {
        return lottery.stream()
                .sorted()
                .map(lotteryNumberFormatter::format)
                .collect(Collectors.joining(DELIMITER, PREFIX, POSTFIX));
    }
}
