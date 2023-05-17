package lotto.model;

import java.util.Arrays;
import java.util.Scanner;
import java.util.Set;
import java.util.stream.Collectors;

import static lotto.model.LotteryEnum.NUMBER_PER_TICKET;

public class ManualLotteryNumberGenerator implements LotteryNumberGenerator {

    private static final Scanner scanner = new Scanner(System.in);
    private static final String SPLIT_REGEX = ", ";

    @Override
    public Set<LotteryNumber> generate() {
        String ticketNumberString = scanner.nextLine();
        Set<LotteryNumber> result = Arrays.stream(ticketNumberString.split(SPLIT_REGEX)).map(Integer::parseInt).map(LotteryNumber::of).collect(Collectors.toSet());
        validate(result);
        return result;
    }

    private void validate(Set<LotteryNumber> numbers) {
        if (numbers.size() != NUMBER_PER_TICKET.value() || numbers.stream().distinct().count() != NUMBER_PER_TICKET.value()) {
            throw new IllegalArgumentException("잘못된 로또 번호 목록입니다. : " + numbers);
        }
    }
}
