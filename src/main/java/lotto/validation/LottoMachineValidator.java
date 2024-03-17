package lotto.validation;

import lotto.exception.InvalidLottoException;

import static lotto.model.LottoMachine.LOTTO_PER_MONEY;

public class LottoMachineValidator {

    public static void assertMoney(int money) {
        if (money < LOTTO_PER_MONEY) {
            throw new InvalidLottoException(LOTTO_PER_MONEY + "원 이상의 금액을 입력해주세요");
        }
    }

}
