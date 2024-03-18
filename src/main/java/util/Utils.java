package util;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import model.LottoNumber;

public final class Utils {

    private Utils() {
    }

    public static List<Integer> convertToNumbers(final String[] stringNumbers) {
        return Stream.of(stringNumbers)
            .map(Integer::parseInt)
            .collect(Collectors.toList());
    }

    public static List<LottoNumber> convertToLottoNumbers(final List<Integer> numbers) {
        return numbers.stream()
                .map(LottoNumber::new)
                .collect(Collectors.toList());
    }
}
