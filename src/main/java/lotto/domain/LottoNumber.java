package lotto.domain;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LottoNumber {

    private static final int MATCH_ONE = 1;
    private static final int NOT_MATCH_ZERO = 0;
    private static final int MIN = 1;
    private static final int MAX = 45;
    public static final int MAX_LOTTO_NUMBER_COUNT = 6;
    private static final String COMMA_EMPTY_STRING = ", ";

    private final List<Number> lottoNumber;

    private LottoNumber(final List<Number> lottoNumber) {

        this.lottoNumber = lottoNumber;
    }

    public static LottoNumber from(final String input) {

        validate(input);
        final List<Number> lottoNumbers = split(input);
        validateSize(lottoNumbers);

        return new LottoNumber(lottoNumbers);
    }

    public static LottoNumber from(final List<Integer> lottoNumber) {

        return new LottoNumber(convert(lottoNumber));
    }

    private static void validate(final String input) {

        if (input == null || input.isBlank()) {
            throw new IllegalArgumentException("입력 값이 null 또는 빈 공백 입니다.");
        }
    }

    private static void validateSize(final List<Number> lottoNumbers) {

        final Set<Number> numbers = new HashSet<>(lottoNumbers);
        if (numbers.size() != MAX_LOTTO_NUMBER_COUNT) {
            throw new IllegalArgumentException("6개의 숫자를 입력해야 하며 중복 숫자는 입력할 수 없습니다.");
        }
    }

    private static List<Number> split(final String input) {

        return Arrays.stream(input.split(COMMA_EMPTY_STRING))
                .sorted()
                .map(number -> new Number(Integer.parseInt(number)))
                .collect(Collectors.toList());
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

    public boolean matchBonus(final WinningLottoNumber winningLottoNumber) {

        return this.lottoNumber.contains(winningLottoNumber.getBonusNumber());
    }
}
