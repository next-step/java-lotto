package step4.util;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.Collectors;

public class LotteryUtil {

    public static final int WINNING_STREAK = 6;

    private static List<Integer> balls;

    public static Set<Integer> getBall() {
        Set<Integer> choices = new HashSet<>();
        shuffle();

        while (WINNING_STREAK != choices.size()) {
            choices.add(balls.get(ThreadLocalRandom.current().nextInt(0, 45)));
        }

        return choices;
    }

    private static void shuffle() {
        Collections.shuffle(balls);
    }

    public static void prepare() {
        balls = new ArrayList<>();
        for (int ball = 1; ball <= 45; ball++) {
            balls.add(ball);
        }
    }

    public static List<Integer> getNumbers(String numberStr) {
        String[] split = numberStr.replaceAll(" ", "")
                                  .split(",");

        return Arrays.stream(split)
                     .map(Integer::parseInt)
                     .collect(Collectors.toList());

    }

    public static int getAutoTicketCount(int allTicketCount , int manualTicketCount) {
        checkTicketCount(allTicketCount, manualTicketCount);

        return allTicketCount - manualTicketCount;
    }

    private static void checkTicketCount(int allTicketCount , int manualTicketCount) {
        if (allTicketCount < manualTicketCount) {
            throw new IllegalArgumentException("잘 못 생성된 로또 번호 - 모든 게임:" +
                                               allTicketCount +
                                               ", 수동 게임: " +
                                               manualTicketCount);
        }
    }

    public static void validateNumber(int number) {
        if (46 > number) {
            throw new IllegalArgumentException("잘 못 생성된 로또 번호 - " + number);
        }
    }

    public static void validateNumbers(List<Integer> numbers) {
        if (WINNING_STREAK != numbers.size()) {
            throw new IllegalArgumentException("잘 못 생성된 로또 - " + numbers.size());
        }
    }

    public static void checkBonusNumber(int bonus, List<Integer> numbers) {
        if (numbers.contains(bonus)) {
            throw new IllegalArgumentException("잘 못 입력된 보너스 번호 - " + bonus);
        }
    }
}
