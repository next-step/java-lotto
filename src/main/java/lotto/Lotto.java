package lotto;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Lotto {
    private static final int LOTTERY_LIMIT = 45;
    private static final int LOTTERY_TICKET_LENGTH = 6;
    private static final List<Integer> lotteryRange =
            IntStream.rangeClosed(1, LOTTERY_LIMIT)
                    .boxed().collect(Collectors.toList());


    private int matchingCount;
    private final HashSet<Integer> lotteryNumbers;
    public Lotto() {
        matchingCount = 0;
        lotteryNumbers = publishLottery();
    }

    public Lotto(HashSet<Integer> numbers) {
        lotteryNumbers = numbers;
    }

    public List<Integer> getLotteryRange() {
        return lotteryRange;
    }

    private HashSet<Integer> publishLottery() {
        Collections.shuffle(lotteryRange);
        HashSet<Integer> lotteryNumbers =
                new HashSet<>(
                        lotteryRange.subList(0, LOTTERY_TICKET_LENGTH)
                );
        return lotteryNumbers;
    }

    public HashSet<Integer> getLotteryNumbers() {
        return lotteryNumbers;
    }

    public int match(HashSet<Integer> numbers, int bonusNumber) {
        int matchingCount = (int) lotteryNumbers.stream()
                .filter(it -> numbers.contains(it))
                .count();
        boolean bonusMatch = lotteryNumbers.contains(bonusNumber);
        return winningCheck(matchingCount, bonusMatch);
    }

    private int winningCheck(int matchingCount, boolean bonusMatch) {
        if (matchingCount == 6) {
            return 1;
        }
        if (matchingCount == 5 && bonusMatch) {
            return 2;
        }
        if (matchingCount == 5 ) {
            return 3;
        }
        if (matchingCount == 4) {
            return 4;
        }
        if (matchingCount ==3) {
            return 5;
        }
        return 6;
    }

    public int getMatchingCount() {
        return matchingCount;
    }
}


