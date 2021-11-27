package domain;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LotteryNumbers {
    private static final int LOTTERY_START_SIZE = 0;
    private static final int LOTTERY_END_SIZE = 6;
    private static final int LOTTERY_START_NUMBER = 1;
    private static final int LOTTERY_END_NUMBER = 46;
    private static final String LOTTERY_SIZE_ERROR_MESSAGE = "error : 로또번호는 6개 입니다.";
    private static final String LOTTERY_NUMBER_RANGE_ERROR_MESSAGE = "error : 사용가능한 로또번호 범위가 아닙니다.";

    private static final List<LotteryNumber> lotteryNumbers = balls();

    private LotteryNumbers() {
    }

    private static List<LotteryNumber> balls() {
        return IntStream.range(LOTTERY_START_NUMBER, LOTTERY_END_NUMBER)
                .mapToObj(LotteryNumber::new)
                .collect(Collectors.toList());
    }

    public static List<LotteryNumber> bringNumber() {
        Collections.shuffle(lotteryNumbers);

        return Collections.unmodifiableList(lotteryNumbers.subList(LOTTERY_START_SIZE, LOTTERY_END_SIZE)
                .stream()
                .sorted(Comparator.comparing(LotteryNumber::value))
                .collect(Collectors.toList()));
    }

    public static List<LotteryNumber> validManualNumber(Set<Integer> manualNumber){
        validLotterySize(manualNumber.size());
        validLotteryNumberSize(manualNumber);

        return Collections.unmodifiableList(manualNumber.stream()
                .map(LotteryNumber::new)
                .sorted(Comparator.comparing(LotteryNumber::value))
                .collect(Collectors.toList()));
    }

    private static void validLotterySize(int size){
        if(size != LOTTERY_END_SIZE){
            throw new IllegalArgumentException(LOTTERY_SIZE_ERROR_MESSAGE);
        }
    }

    private static void validLotteryNumberSize(Set<Integer> manualNumber){
        for(int number : manualNumber){
            validLotteryNumber(number);
        }
    }

    private static void validLotteryNumber(int number){
        if(number < LOTTERY_START_NUMBER || number > LOTTERY_END_NUMBER){
            throw new IllegalArgumentException(LOTTERY_NUMBER_RANGE_ERROR_MESSAGE);
        }
    }

}
