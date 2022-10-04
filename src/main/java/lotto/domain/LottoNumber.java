package lotto.domain;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LottoNumber {

    private static final int MATCH_ONE = 1;
    private static final int NOT_MATCH_ZERO = 0;
    private static final int MIN = 1;
    private static final int MAX = 45;

    private static final String COMMA_EMPTY_STRING = ", ";

    private final List<Number> lottoNumber;

    private LottoNumber(final List<Number> lottoNumber) {

        this.lottoNumber = lottoNumber;
    }

    public static LottoNumber from(final String input) {

        validate(input);
        return new LottoNumber(split(input));
    }

    private static void validate(final String input) {

        if (input == null || input.isBlank()) {
            throw new IllegalArgumentException("입력 값이 null 또는 빈 공백 입니다.");
        }
    }

    private static List<Number> split(final String input) {

        return Arrays.stream(input.split(COMMA_EMPTY_STRING))
                .sorted()
                .map(number -> new Number(Integer.parseInt(number)))
                .collect(Collectors.toList());
    }

    public static LottoNumber from(final List<Integer> lottoNumber) {

        return new LottoNumber(convert(lottoNumber));
    }

    private static List<Number> convert(final List<Integer> numbers) {

        return numbers.stream()
                .map(Number::new)
                .collect(Collectors.toList());
    }

    public static List<Integer> create() {

        return IntStream.range(MIN, MAX)
                .boxed()
                .collect(Collectors.toList());
    }

    public int match(final WinningLottoNumber winningLottoNumber) {

        int result = 0;
        for (Number winningNumber : winningLottoNumber.getWinnerLottoNumber()) {
            result += compare(winningNumber);
        }
        return result;
    }

    private int compare(final Number winningNumber) {

        if (this.lottoNumber.contains(winningNumber)) {
            return MATCH_ONE;
        }
        return NOT_MATCH_ZERO;
    }

    public List<Number> getLottoNumber() {

        return Collections.unmodifiableList(this.lottoNumber);
    }
}
