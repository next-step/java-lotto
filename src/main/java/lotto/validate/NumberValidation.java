package lotto.validate;

import lotto.domain.Lotto;
import lotto.domain.LottoNumber;

import java.util.List;

import static lotto.message.LottoErroMessage.*;

public class NumberValidation {

    public static void checkNumberRange(int number) {
        if (number < 1 || number > 45) {
            throw new IllegalArgumentException(NOT_ENOUGH_LOTTO_NUMBER_RANGE.getMessage());
        }
    }

    public static void checkLottoSize(List<LottoNumber> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException(NOT_ENOUGH_LOTTO_NUMBER.getMessage());
        }
    }

    public static void checkBonusNumber(Lotto lotto, LottoNumber bonusNumber) {
        checkNumberRange(bonusNumber.number());
        if (lotto.matchBonus(bonusNumber)) {
            throw new IllegalArgumentException(NOT_ENOUGH_LOTTO_BONUS_NUMBER.getMessage());
        }
    }
}
