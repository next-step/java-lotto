package lottery.domain.createstrategy;

import lottery.domain.Lottery;
import lottery.domain.Money;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class ManualCreatingLotteryStrategy implements CreatingLotteryStrategy {

    private static final String NON_NULL = "입력값은 null 일 수 없습니다";

    private final List<String> stringLotteries;

    public ManualCreatingLotteryStrategy(final List<String> stringLotteries) {
        requireNonNull(stringLotteries);
        this.stringLotteries = stringLotteries;
    }

    @Override
    public List<Lottery> createLotteries(final Money money) {
        return stringLotteries.stream()
                .peek(lottery -> money.extractLotteryPrice())
                .map(Lottery::new)
                .collect(Collectors.toList());
    }

    private void requireNonNull(final List<String> stringLotteries) {
        if (Objects.isNull(stringLotteries)) {
            throw new IllegalArgumentException(NON_NULL);
        }
    }
}
