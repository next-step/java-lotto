package lotto.domain.lotto;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import lotto.domain.lotto.exception.InvalidLottoNumberException;

public class LottoFactory {

    private static final int LOTTO_NUMBER_COUNT = 6;
    private static final long LOTTO_PRICE = 1000;

    public static NormalLotto createNormal() {
        Set<Integer> randomNumbers = new HashSet<>();
        while (randomNumbers.size() < LOTTO_NUMBER_COUNT) {
            randomNumbers.add(LottoNumber.create());
        }

        return new NormalLotto(new ArrayList<>(randomNumbers));
    }

    public static WinningLotto createWinning(List<Integer> numbers) {
        validation(numbers);
        return new WinningLotto(numbers);
    }

    private static void validation(List<Integer> checkNumbers) {
        if (!LottoNumber.isValid(checkNumbers)) {
            throw new InvalidLottoNumberException();
        }

        if (checkNumbers.stream().distinct().count() != LOTTO_NUMBER_COUNT) {
            throw new InvalidLottoNumberException();
        }
    }

    public static int possiblePurchaseLottoCount(long totalAmount) {
        return (int) (totalAmount / LOTTO_PRICE);
    }

    public static long calculateTotalAmount(int purchasedLottoCount) {
        return purchasedLottoCount * LOTTO_PRICE;
    }
}
