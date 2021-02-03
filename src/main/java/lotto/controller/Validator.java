package lotto.controller;

import java.util.Arrays;
import java.util.List;
import java.util.regex.Pattern;
import lotto.util.NumberUtils;

public class Validator {

    private static final int ONE_LOTTO_PRICE = 1000;
    private static final String FORMAT_REGEX = "[0-9]+(,\\s[0-9]+)*$";
    private static final String COMMA = ", ";
    private static final int LOTTO_COUNT = 6;

    public boolean isPriceValidate(String price) {
        Integer priceOrNull = NumberUtils.returnInteger(price);
        return priceOrNull != null && priceOrNull != 0 && priceOrNull % ONE_LOTTO_PRICE == 0;
    }

    public boolean validateWinningNumber(String winningNumber) {
        Pattern pattern = Pattern.compile(FORMAT_REGEX);
        List<String> numbers = Arrays.asList(winningNumber.split(COMMA));
        return pattern.matcher(winningNumber).matches()
            && numbers.size() == LOTTO_COUNT
            && NumberUtils.isNumberUnique(numbers)
            && NumberUtils.isNumberInLottoRange(numbers);
    }

    public boolean validateBonusNumber(String bonusNumber) {
        Integer bonusNumberOrNull = NumberUtils.returnInteger(bonusNumber);
        return bonusNumberOrNull != null && NumberUtils.checkLottoNumber(bonusNumberOrNull);
    }
}
