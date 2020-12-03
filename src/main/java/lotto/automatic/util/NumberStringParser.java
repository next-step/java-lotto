package lotto.automatic.util;

import lotto.automatic.domain.LottoNumber;

import java.util.ArrayList;
import java.util.List;

public class NumberStringParser {

    public static List<LottoNumber> parseString(String rawNumberString) throws NumberFormatException{
        String[] numberStrings = rawNumberString.split(",");
        List<LottoNumber> nums = new ArrayList<>();

        for (String numString : numberStrings) {
            nums.add(LottoNumber.of(Integer.parseInt(numString.trim())));
        }
        return nums;
    }
}
