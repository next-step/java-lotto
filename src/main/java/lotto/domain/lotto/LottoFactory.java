package lotto.domain.lotto;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LottoFactory {

    public static final int LOTTO_NUMBER_MIN = 1;
    public static final int LOTTO_NUMBER_MAX = 45;
    public static final int LOTTO_NUMBER_COUNT = 6;
    public static final long LOTTO_PRICE = 1000;

    private final static List<Integer> numbers = IntStream.rangeClosed(LOTTO_NUMBER_MIN, LOTTO_NUMBER_MAX)
        .boxed()
        .collect(Collectors.toList());

    public static NormalLotto createNormal() {
        Collections.shuffle(numbers);
        List<Integer> randomNumbers = numbers.stream()
            .limit(LOTTO_NUMBER_COUNT)
            .collect(Collectors.toList());

        return new NormalLotto(randomNumbers);
    }

    public static WinningLotto createWinning(List<Integer> numbers) {
        return new WinningLotto(numbers);
    }

    public static boolean isValid(List<Integer> checkNumbers) {
        if (!numbers.containsAll(checkNumbers)) {
            return false;
        }

        if (checkNumbers.stream().distinct().count() != LOTTO_NUMBER_COUNT) {
            return false;
        }

        return true;
    }

    public static int possiblePurchaseLottoCount(long totalAmount) {
        return (int) (totalAmount / LOTTO_PRICE);
    }

    public static long calculateTotalAmount(int purchasedLottoCount) {
        return purchasedLottoCount * LOTTO_PRICE;
    }
}
