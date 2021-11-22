package domain;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Number {
    private static final int LOTTERY_START_SIZE = 0;
    private static final int LOTTERY_END_SIZE = 6;
    private static final int LOTTERY_START_NUMBER = 1;
    private static final int LOTTERY_END_NUMBER = 46;
    private static final String NUMBER_ERROR_MESSAGE = "error : 유효하지 않는 번호 입니다.";
    private static final List<Integer> lotteryBalls = IntStream.range(LOTTERY_START_NUMBER, LOTTERY_END_NUMBER)
            .boxed()
            .collect(Collectors.toList());

    private Number() {
    }

    public static List<Integer> bringNumber() {
        Collections.shuffle(lotteryBalls);
        return lotteryBalls.subList(LOTTERY_START_SIZE, LOTTERY_END_SIZE)
                .stream()
                .sorted()
                .collect(Collectors.toList());
    }

    private static boolean checkNumberList(int number) {
        if (number < LOTTERY_START_NUMBER || number >= LOTTERY_END_NUMBER) {
            return true;
        }
        return false;
    }

    private static void errorNumber(int count) {
        if (count > 0) {
            throw new IllegalArgumentException(NUMBER_ERROR_MESSAGE);
        }
    }

}
