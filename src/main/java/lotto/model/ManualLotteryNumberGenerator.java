package lotto.model;

import java.util.Arrays;
import java.util.Scanner;
import java.util.Set;
import java.util.stream.Collectors;

public class ManualLotteryNumberGenerator implements LotteryNumberGenerator {

    private static final Scanner scanner = new Scanner(System.in);
    private static final String SPLIT_REGEX = ", ";

    @Override
    public Set<LotteryNumber> generate() {
        String ticketNumberString = scanner.nextLine();
        return Arrays.stream(ticketNumberString.split(SPLIT_REGEX)).map(Integer::parseInt).map(LotteryNumber::of).collect(Collectors.toSet());
    }
}
