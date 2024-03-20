package lotto.validation;

import lotto.exception.InvalidLottoException;
import lotto.model.Money;

import static lotto.model.LottoMachine.LOTTO_PER_MONEY;

public class LottoMachineValidator {

    public static void assertMoney(Money money) {
        if (money.lessThan(LOTTO_PER_MONEY)) {
            throw new InvalidLottoException(LOTTO_PER_MONEY + "원 이상의 금액을 입력해주세요");
        }
    }

}
