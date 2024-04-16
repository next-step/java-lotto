package lotto.parser;

import lotto.constant.ErrorMessage;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class LottoNumberParser {
    public static List<Integer> parse(String input) {
        try {
            return Arrays.stream(
                    input.replaceAll("\\s", "").split(",")
            ).mapToInt(Integer::parseInt).boxed().collect(Collectors.toList());
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ErrorMessage.LOTTO_NUMBER_NUMERIC_ERROR.getMessage());
        }
    }
}
