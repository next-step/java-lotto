package step3.domain;

import step3.exception.LottoCountBoundException;
import step3.exception.ValidEmptyException;
import step3.exception.ValidNullException;

import java.util.Arrays;
import java.util.stream.Collectors;

public class LastWeekLottoGenerator {


    private static final String DELIMITER_LOTTO = ",";

    private LastWeekLottoGenerator() {}

    public static Lotto separateLottoToList(String input) {
        validNull(input);
        validEmpty(input);

        return new Lotto(Arrays.stream(separateLottoNumber(input))
                .map(s -> Integer.parseInt(s.trim()))
                .collect(Collectors.toList()));
    }

    private static String[] separateLottoNumber(String input) {
        String[] split = input.split(DELIMITER_LOTTO);

        validLottoNumberCount(split);

        return split;
    }

    private static void validLottoNumberCount(String[] split) {
        if (split.length != 6) {
            throw new LottoCountBoundException();
        }
    }

    private static void validNull(String input) {
        if (input == null) {
            throw new ValidNullException();
        }
    }

    private static void validEmpty(String input) {
        if (input.trim().isEmpty()) {
            throw new ValidEmptyException();
        }
    }
}
