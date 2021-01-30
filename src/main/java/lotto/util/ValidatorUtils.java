package lotto.util;

import java.util.Arrays;
import java.util.List;
import java.util.regex.Pattern;

public class ValidatorUtils {

    private static final int ONE_LOTTO_PRICE = 1000;
    private static final String FORMAT_REGEX = "[0-9]+(,\\s[0-9]+)*$";
    private static final String COMMA = ", ";
    private static final int LOTTO_COUNT = 6;

    public boolean isPriceValidate(String price) throws IllegalArgumentException {
        Integer priceOrNull = NumberUtils.returnInteger(price);
        if (priceOrNull != null && priceOrNull != 0 && priceOrNull % ONE_LOTTO_PRICE == 0) {
            return true;
        }
        throw new IllegalArgumentException();
    }

    public boolean validateWinningNumber(String winningNumber) throws IllegalArgumentException {
        if (Pattern.compile(FORMAT_REGEX).matcher(winningNumber).matches()
            && validateLottoConditions(Arrays.asList(winningNumber.split(COMMA)))) {
            return true;
        }
        throw new IllegalArgumentException();
    }

    public boolean validateBonusNumber(String bonusNumber) throws IllegalArgumentException {
        Integer bonusNumberOrNull = NumberUtils.returnInteger(bonusNumber);
        if (bonusNumberOrNull != null && NumberUtils.checkLottoNumber(bonusNumberOrNull)) {
            return true;
        }
        throw new IllegalArgumentException();
    }

    private boolean validateLottoConditions(List<String> numbers) throws IllegalArgumentException {
        if (numbers.size() == LOTTO_COUNT
            && NumberUtils.isNumberUnique(numbers)
            && NumberUtils.isNumberInRange(numbers)) {
            return true;
        }
        throw new IllegalArgumentException();
    }
}
