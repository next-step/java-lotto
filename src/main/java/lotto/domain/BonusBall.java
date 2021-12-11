package lotto.domain;

import lotto.exception.LottoNumberException;

import static lotto.domain.lotto.Lotto.*;

public class BonusBall {

    private static final String ERR_NUMBER_FORMAT = "숫자 형식 데이터가 아닙니다";

    private final int bonus;

    private BonusBall(String bonus) {
        try {
            this.bonus = Integer.parseInt(bonus);
            valid();

        } catch (NumberFormatException e) {
            throw new LottoNumberException(ERR_NUMBER_FORMAT);
        }
    }

    public static BonusBall of(String bonus) {
        return new BonusBall(bonus);
    }

    public int getBonus() {
        return bonus;
    }

    private void valid() {
        if (bonus < START_NUMBER || bonus > END_NUMBER) {
            throw new LottoNumberException(ERR_MESSAGE_RANGE);
        }
    }
}
