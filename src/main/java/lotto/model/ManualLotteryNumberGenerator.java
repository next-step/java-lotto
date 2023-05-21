package lotto.model;

import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;

import static lotto.model.LotteryEnum.NUMBER_PER_TICKET;

public class ManualLotteryNumberGenerator implements LotteryNumberGenerator {

    private static final String SPLIT_REGEX = ", ";
    private final Set<LotteryNumber> result;

    private ManualLotteryNumberGenerator(Set<LotteryNumber> result) {
        this.result = result;
    }

    public static ManualLotteryNumberGenerator from(String ticketNumberString) {
        return new ManualLotteryNumberGenerator(Arrays.stream(ticketNumberString.split(SPLIT_REGEX)).map(Integer::parseInt).map(LotteryNumber::of).collect(Collectors.toSet()));
    }

    @Override
    public Set<LotteryNumber> generate() {
        validate(result);
        return result;
    }

    private void validate(Set<LotteryNumber> numbers) {
        if (numbers.size() != NUMBER_PER_TICKET.value() || numbers.stream().distinct().count() != NUMBER_PER_TICKET.value()) {
            throw new IllegalArgumentException("잘못된 로또 번호 목록입니다. : " + numbers);
        }
    }
}
