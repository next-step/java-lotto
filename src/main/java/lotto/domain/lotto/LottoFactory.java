package lotto.domain.lotto;

import java.util.Set;
import lotto.domain.lotto.exception.InvalidLottoNumberException;

public class LottoFactory {

    private static final int LOTTO_PRICE = 1000;

    public static NormalLotto createNormal() {
        return new NormalLotto(LottoNumbers.create());
    }

    public static WinningLotto createWinning(Set<Integer> numbers, int bonusNumber) {
        validationWinningLotto(numbers, bonusNumber);
        return new WinningLotto(LottoNumbers.create(numbers), bonusNumber);
    }

    private static void validationWinningLotto(Set<Integer> checkNumbers, int bonusNumber) {
        if (checkNumbers.contains(bonusNumber)
            || !LottoNumber.isValid(checkNumbers)
            || !LottoNumber.isValid(bonusNumber)) {
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
