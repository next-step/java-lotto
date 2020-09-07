package AutoLotto.utils;

import AutoLotto.domain.lotto.LottoNumber;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static AutoLotto.utils.Constants.*;
import static AutoLotto.utils.CheckString.isNullOrBlank;

public class CheckRegex {

    public static List<LottoNumber> makeBuzzLotto(String input) {
        if (isNullOrBlank(input)) {
            throw new RuntimeException();
        }
        return toLotto(toLottoNumberList(splitToTokens(input)));
    }

    private static List<LottoNumber> toLotto(List<LottoNumber> checkLottoNumberRegex) {
        if (checkLottoNumberRegex.stream().distinct().collect(Collectors.toList()) != checkLottoNumberRegex) {
            throw new RuntimeException();
        }
        return checkLottoNumberRegex;
    }

    private static String[] splitToTokens(String input) {
        String[] tokens = input.split(INPUT_NUMBERS_DELIMITER);
        if (tokens.length != LOTTO_NUMBER_COUNT) {
            throw new RuntimeException();
        }
        return tokens;
    }


    private static List<LottoNumber> toLottoNumberList(String[] tokens) {
        return Arrays.stream(tokens)
                .map(token -> LottoNumber.checkLottoNumber(toInt(token)))
                .map(number -> new LottoNumber(number))
                .collect(Collectors.toList());
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


// token.matches("^[1-9]{1}$|^[1-3]{1}[0-9]{1}|^4{1}[0-5]{1}"))

}
