package lotto.domain.lotto;

import java.util.HashSet;
import java.util.Set;
import lotto.domain.lotto.exception.InvalidLottoNumberException;

public class LottoFactory {

    private static final int LOTTO_NUMBER_COUNT = 6;
    private static final int LOTTO_PRICE = 1000;

    public static NormalLotto createNormal() {
        Set<Integer> randomNumbers = new HashSet<>();
        while (randomNumbers.size() < LOTTO_NUMBER_COUNT) {
            randomNumbers.add(LottoNumber.create());
        }

        return new NormalLotto(randomNumbers);
    }

    public static WinningLotto createWinning(Set<Integer> numbers) {
        validation(numbers);
        return new WinningLotto(numbers);
    }

    private static void validation(Set<Integer> checkNumbers) {
        if (!LottoNumber.isValid(checkNumbers)) {
            throw new InvalidLottoNumberException();
        }

        if (checkNumbers.size() != LOTTO_NUMBER_COUNT) {
            throw new InvalidLottoNumberException();
        }
    }

    public static int possiblePurchaseLottoCount(int totalAmount) {
        return totalAmount / LOTTO_PRICE;
    }

    public static int calculateTotalAmount(int purchasedLottoCount) {
        return purchasedLottoCount * LOTTO_PRICE;
    }
}
