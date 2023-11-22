package lotto.domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Parser {
    private static final String LOTTO_DELIMITER = ",";
    private static final String EMPTY_SPACE = " ";

    private Parser() {
    }

    public static int numberParsing(String value) {
        int number = parseNumberFormat(value);
        if (number < 0) {
            throw new IllegalArgumentException("숫자가 음수이면 안됩니다.");
        }
        return parseNumberFormat(value);
    }

    public static int parseNumberFormat(String numberString) {
        try {
            return Integer.parseInt(numberString);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("숫자가 아닙니다");
        }
    }

    public static List<LottoNumber> numbersParsing(String value) {

        value = value.replaceAll(EMPTY_SPACE, "");

        List<LottoNumber> numbers = stringNumbersConversion(stringSplit(value));

        if (numbers.size() != 6) {
            throw new IllegalArgumentException("숫자는 6개를 입력해야됩니다.");
        }
        return numbers;
    }

    private static List<String> stringSplit(String value) {
        String[] splitText = value.split(LOTTO_DELIMITER);
        return Arrays.asList(splitText);
    }

    private static List<LottoNumber> stringNumbersConversion(List<String> values) {
        List<LottoNumber> numbers = new ArrayList<>();
        for (String value : values) {
            numbers.add(new LottoNumber(numberParsing(value)));
        }
        return numbers;
    }
}
