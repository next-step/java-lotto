package step2.util;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class LottoStringtoNumbers {

    private static final String EXCEPTION_NOT_NUMBER = "숫자만 입력해 주세요";
    private static final String DELIMETER = ",";

    public static List<Integer> convertStringtoNumbers(String inputWinnerNumbers) {
        try {
            return Stream.of(inputWinnerNumbers.split(DELIMETER))
                    .map(String::trim)
                    .map(Integer::parseInt)
                    .collect(Collectors.toList());
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(EXCEPTION_NOT_NUMBER, e);
        }
    }
}
