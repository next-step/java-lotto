package lotto.controller;

import java.util.Arrays;
import java.util.regex.Pattern;
import lotto.util.NumberUtils;

public class Validator {

    private static final int ONE_LOTTO_PRICE = 1000;
    private static final String FORMAT_REGEX = "[0-9]+(,[0-9]+)*$";

    public boolean isPriceValidate(String price) throws NumberFormatException {
        Integer priceOrNull = NumberUtils.returnInteger(price);
        return priceOrNull != null && priceOrNull != 0 && priceOrNull % ONE_LOTTO_PRICE == 0;
    }

    public boolean validateWinningNumber(String winningNumber) {
        // String 받아 올때 " " 없애서 받아오기!
        String trimed = winningNumber.replaceAll(" ", "");  // 임시 코드
        // TODO: length check. 하드 코딩 했음!!! 다른 방법 알아보기!
        // TODO: unique Number check.
        Pattern pattern = Pattern.compile(FORMAT_REGEX);
        return winningNumber.length() == 11 && pattern.matcher(trimed).matches() && isNumberInRange(trimed);
    }

    public boolean isNumberUnique(String number) {
        // TODO: 하드코딩 리팩토링!
        String[] numbers = number.split(",");
        return Arrays.stream(numbers).distinct().collect();
    }

    // NumberUtil로..?
    public boolean isNumberInRange(String numbers) {
        return Arrays
            .stream(numbers.split(","))
            .map(Integer::parseInt)
            .allMatch(number -> (number > 0 && number < 46));
    }

    public boolean validateBonusNumber(String bonusNumber) {
        return false;
    }

}
