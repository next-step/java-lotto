package lotto;

import lotto.domain.LottoNumber;

import java.util.LinkedHashSet;
import java.util.Set;

public class StringParser {

    public static Set<LottoNumber> getParseNumbers(String input) {
        return toIntegers(getSplits(input));
    }

    private static String[] getSplits(String input) {
        input = input.replaceAll(" ", "");
        return input.split(",");
    }

    private static Set<LottoNumber> toIntegers(String[] split) {
        Set<LottoNumber> result = new LinkedHashSet<>();

        try {
            for (String number : split) {
                result.add(new LottoNumber(Integer.parseInt(number)));
            }
        } catch (NumberFormatException e) {
            System.out.println("숫자와 (,) 구분자로 이루어진 문자열을 입력해 주세요.");
            e.printStackTrace();
        }
        return result;
    }
}
