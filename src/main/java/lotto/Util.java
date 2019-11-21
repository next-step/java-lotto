package lotto;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

/**
 * @author : 김윤호
 * @version : 1.0
 * @date : 2019-11-21 00:02
 */
public final class Util {
    private static final Pattern NUMERIC = Pattern.compile("^[0-9]+$");
    private static final Predicate<String> IS_NUMERIC = str -> NUMERIC.matcher(str).matches();

    public static List<Integer> stringToList(String manualLottoNumber) {
        return Arrays.stream(manualLottoNumber.split(","))
                .map(String::trim)
                .filter(IS_NUMERIC)
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }
}
