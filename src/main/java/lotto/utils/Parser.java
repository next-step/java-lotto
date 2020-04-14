package lotto.utils;

import lotto.domain.LottoNumber;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Parser {
    private static final String NOT_NUMBER = "숫자가 아닙니다. ";
    private static final String DELIMETER = ",";

    private Parser() {
    }

    public static List<LottoNumber> splitToNumbers(String text) {
        return Stream.of(text.split(DELIMETER))
                .map(String::trim)
                .map(Parser::parseToInt)
                .map(LottoNumber::new)
                .collect(Collectors.toList());
    }

    private static int parseToInt(String inputText) {
        try {
            return (Integer.parseInt(inputText));
        } catch (Exception e) {
            throw new NumberFormatException(NOT_NUMBER + e.getMessage());
        }
    }
}
