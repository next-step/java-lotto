package camp.nextstep.edu.lotto.view.console.formatter;

import camp.nextstep.edu.lotto.domain.Lotteries;
import camp.nextstep.edu.lotto.domain.Lottery;

import java.util.stream.Collectors;

public class LotteriesFormatter implements Formatter<Lotteries> {
    private static final String DELIMITER = "\n";

    private final Formatter<Lottery> lotteryFormatter;

    public LotteriesFormatter(Formatter<Lottery> lotteryFormatter) {
        this.lotteryFormatter = lotteryFormatter;
    }

    @Override
    public String format(Lotteries lotteries) {
        return lotteries.stream()
                .map(lotteryFormatter::format)
                .collect(Collectors.joining(DELIMITER));
    }
}
