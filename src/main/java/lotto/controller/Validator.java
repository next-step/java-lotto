package lotto.controller;

import lotto.util.NumberUtils;

public class Validator {

    private Validator() {

    }

    public static boolean validateBonusNumber(String bonusNumber) {
        Integer bonusNumberOrNull = NumberUtils.returnInteger(bonusNumber);
        return bonusNumberOrNull != null && NumberUtils.checkLottoNumber(bonusNumberOrNull);
    }
}
