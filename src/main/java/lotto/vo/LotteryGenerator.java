package lotto.vo;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LotteryGenerator {
    public static final String FORMAT_COMMA = ",";
    private static final int START_LOTTERY_NUMBER = 1;
    private static final int END_LOTTERY_NUMBER = 45;
    private static final int FROM_LOTTERY_INDEX = 0;
    private static final int TO_LOTTERY_INDEX = 6;
    private static final String FORMAT_PREFIX_BRACKET = "[";
    private static final String FORMAT_SUFFIX_BRACKET = "]";
    private List<Integer> lotteryNumbers;

    public LotteryGenerator() {
        lotteryNumbers = new ArrayList<>();
        lottoMake();
    }

    public LotteryNumber lottoMake() {
        List<Integer> lotteryFullNumbers = createLotteryNumbers();
        Collections.shuffle(lotteryFullNumbers);
        Collections.sort(lotteryFullNumbers);
        return LotteryNumber.toObject(split6digit(lotteryFullNumbers));
    }

    private Set<Integer> split6digit(List<Integer> lotteryFullNumbers) {
        return new HashSet<>(lotteryFullNumbers.subList(FROM_LOTTERY_INDEX, TO_LOTTERY_INDEX));
    }

    private List<Integer> createLotteryNumbers() {
        return IntStream.rangeClosed(START_LOTTERY_NUMBER, END_LOTTERY_NUMBER)
                .boxed()
                .collect(Collectors.toList());
    }

    public String printLottoNumber() {
        return lotteryNumbers.stream()
                .map(String::valueOf)
                .collect(Collectors.joining(FORMAT_COMMA, FORMAT_PREFIX_BRACKET, FORMAT_SUFFIX_BRACKET));
    }
}
