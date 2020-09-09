package AutoLotto.utils;

import AutoLotto.domain.lotto.LottoNumber;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static AutoLotto.utils.Constants.*;
import static AutoLotto.utils.CheckString.isNullOrBlank;

public class CheckLotto {

    public static List<LottoNumber> makeBuzzLotto(String input) {
        if (isNullOrBlank(input)) {
            return null;
        }
        if (collectLottoNumber(input).size() != LOTTO_NUMBER_COUNT) {
            throw new RuntimeException();
        }
        return collectLottoNumber(input);
    }

    private static List<LottoNumber> collectLottoNumber(String input) {
        return Arrays.stream(splitToTokens(input))
                .filter(token -> token.matches(LOTTO_NUMBER_PATTERN))
                .map(token -> new LottoNumber(toInt(token)))
                .collect(Collectors.toList())
                .stream()
                .distinct()
                .collect(Collectors.toList());
    }

    private static String[] splitToTokens(String input) {
        String[] tokens = input.split(INPUT_NUMBERS_DELIMITER);
        return tokens;
    }

    private static int toInt(String token) {
        int number = 0;
        try {
            number = Integer.parseInt(token);
        } catch (NumberFormatException e) {
            throw new RuntimeException();
        }
        return number;
    }
}
