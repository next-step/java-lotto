package lotto.util;

import lotto.domain.LottoNumber;
import lotto.exception.MisMatchNumberException;
import lotto.exception.NumberInputRuleException;

import java.util.InputMismatchException;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StringParser {

    private StringParser() {
    }

    private static final String DEFAULT_PATTERN = ", ";

    public static List<LottoNumber> parseToInts(String text) {
        return Stream.of(text.split(DEFAULT_PATTERN))
                .map(stringNumber -> new LottoNumber(inputNumber(stringNumber)))
                .collect(Collectors.toList());
    }

    private static int inputNumber(String stringFormatNumber) {
        try {
            return Integer.parseInt(stringFormatNumber);
        } catch (NumberFormatException ex) {
            throw new NumberInputRuleException();
        } catch (InputMismatchException ex) {
            throw new MisMatchNumberException();
        }
    }

}
