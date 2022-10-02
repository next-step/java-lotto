package lotto.domain;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class WinningLottoNumber {

    private static final String COMMA_EMPTY_STRING = ", ";
    public static final int MATCH_ONE = 1;
    public static final int NOT_MATCH_ZERO = 0;
    public static final int MAX_LOTTO_NUMBER_COUNT = 6;

    private final List<Number> winnerLottoNumber;

    public WinningLottoNumber(final String input) {

        validate(input);
        this.winnerLottoNumber = convert(input);
    }

    private void validate(final String input) {

        if (input == null || input.isBlank()) {
            throw new IllegalArgumentException("입력 값이 null 또는 빈 공백 입니다.");
        }
    }

    private List<Number> convert(final String input) {

        final List<Number> lottoNumbers = split(input);
        validateSize(lottoNumbers);

        return lottoNumbers;
    }

    private List<Number> split(final String input) {
        return Arrays.stream(input.split(COMMA_EMPTY_STRING))
                .map(number -> new Number(Integer.parseInt(number)))
                .distinct()
                .collect(Collectors.toList());
    }

    private void validateSize(final List<Number> lottoNumbers) {

        if (lottoNumbers.size() != MAX_LOTTO_NUMBER_COUNT) {
            throw new IllegalArgumentException("6개의 숫자를 입력해야 하며 중복 숫자는 입력할 수 없습니다.");
        }
    }

    public int match(final LottoNumber lottoNumber) {

        int result = 0;
        for (Number number : lottoNumber.getLottoNumber()) {
            result += match(number);
        }
        return result;
    }

    private int match(final Number number) {
        if (this.winnerLottoNumber.contains(number)) {
            return MATCH_ONE;
        }
        return NOT_MATCH_ZERO;
    }

    public List<Number> getWinnerLottoNumber() {

        return winnerLottoNumber;
    }

    @Override
    public String toString() {

        return "" + winnerLottoNumber +"";
    }
}
