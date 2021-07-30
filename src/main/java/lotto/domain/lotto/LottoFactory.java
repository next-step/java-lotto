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

    public static WinningLotto createWinning(Set<Integer> numbers, int bonusNumber) {
        validationWinningLotto(numbers, bonusNumber);
        return new WinningLotto(numbers, bonusNumber);
    }

    private static void validationWinningLotto(Set<Integer> checkNumbers, int bonusNumber) {
        if (checkNumbers.contains(bonusNumber)
            || !LottoNumber.isValid(checkNumbers)
            || !LottoNumber.isValid(bonusNumber)
            || checkNumbers.size() != LOTTO_NUMBER_COUNT) {
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
