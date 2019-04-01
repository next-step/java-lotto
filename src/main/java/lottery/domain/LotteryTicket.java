package lottery.domain;

import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;
import java.util.stream.Collectors;

public class LotteryTicket {

    public static final int NUMBERS_COUNT = 6;

    private static final String NUMBER_SEPARATOR = ",";

    private static final String REMOVE_REGEX = " ";

    private final Set<LotteryNumber> lotteryNumbers;

    public LotteryTicket(List<Integer> numbers) {
        this.lotteryNumbers = numbers.stream()
                .sorted()
                .map(LotteryNumber::of)
                .collect(Collectors.toCollection(() -> new TreeSet<>()));

        if (this.lotteryNumbers.size() != NUMBERS_COUNT) {
            throw new IllegalArgumentException();
        }
    }

    public static LotteryTicket generate(String numbers) {
        return new LotteryTicket(toIntegers(split(replace(numbers))));
    }

    private static List<Integer> toIntegers(String[] lines) {
        return Arrays.stream(lines)
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }

    private static String[] split(String line) {
        return line.split(NUMBER_SEPARATOR);
    }

    private static String replace(String line) {
        return line.replaceAll(REMOVE_REGEX, "");
    }


    int countMatchNumbers(LotteryTicket target) {
        return (int) this.lotteryNumbers
                .stream()
                .filter(number -> target.contains(number))
                .count();
    }

    boolean contains(LotteryNumber number) {
        return this.lotteryNumbers
                .contains(number);
    }

    @Override
    public String toString() {
        return lotteryNumbers.toString();
    }
}
