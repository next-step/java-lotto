package lotto.domain;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class WinningLottoNumber {

    private static final String COMMA_EMPTY_STRING = ", ";
    public static final int MAX_LOTTO_NUMBER_COUNT = 6;

    private final List<Number> winnerLottoNumber;

    private WinningLottoNumber(final List<Number> winnerLottoNumber) {

        this.winnerLottoNumber = winnerLottoNumber;
    }

    public static WinningLottoNumber from(final String input) {

        validate(input);
        final List<Number> lottoNumbers = split(input);
        validateSize(lottoNumbers);

        return new WinningLottoNumber(lottoNumbers);
    }

    private static void validate(final String input) {

        if (input == null || input.isBlank()) {
            throw new IllegalArgumentException("입력 값이 null 또는 빈 공백 입니다.");
        }
    }

    private static List<Number> split(final String input) {

        return Arrays.stream(input.split(COMMA_EMPTY_STRING))
                .map(number -> new Number(Integer.parseInt(number)))
                .distinct()
                .collect(Collectors.toList());
    }

    private static void validateSize(final List<Number> lottoNumbers) {

        if (lottoNumbers.size() != MAX_LOTTO_NUMBER_COUNT) {
            throw new IllegalArgumentException("6개의 숫자를 입력해야 하며 중복 숫자는 입력할 수 없습니다.");
        }
    }

    public List<Number> getWinnerLottoNumber() {

        return winnerLottoNumber;
    }
}
