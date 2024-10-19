package lotto.util;

import lotto.model.LottoNumber;

import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class Utils {

    private static final Pattern NumberPattern = Pattern.compile("^[0-9]+$");
    public static final String NUMBER_EXCEPT_MESSAGE = "정수 하나를 입력해주세요!";
    public static final String NUMBER_SEPERATOR = ",";

    public static Set<LottoNumber> stringToSet(String text) {
        return Arrays.stream(text.split(NUMBER_SEPERATOR)).map(LottoNumber::new).collect(Collectors.toSet());
    }

    public static Set<LottoNumber> intsToSet(int[] numbers) {
        return Arrays.stream(numbers).mapToObj(LottoNumber::new).collect(Collectors.toSet());
    }

    public static Set<LottoNumber> integersToSet(List<Integer> numbers) {
        return numbers.stream().map(LottoNumber::new).collect(Collectors.toSet());
    }

    public static Long stringToLong(String text) {
        if (!NumberPattern.matcher(text).matches()) {
            throw new IllegalArgumentException(NUMBER_EXCEPT_MESSAGE);
        }
        return Long.parseLong(text);
    }


}
