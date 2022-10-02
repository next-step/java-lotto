package lotto.domain;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class LottoNumber {

    private static final String COMMA_EMPTY_STRING = ", ";
    
    private final List<Number> lottoNumber;

    public LottoNumber(final String input) {

        validate(input);
        this.lottoNumber = split(input);
    }

    private LottoNumber(final List<Integer> numbers) {

        this.lottoNumber = numbers.stream()
                .map(Number::new)
                .collect(Collectors.toList());
    }

    public static LottoNumber from(final List<Integer> lottoNumber) {

        return new LottoNumber(lottoNumber);
    }

    private void validate(final String input) {

        if (input == null || input.isBlank()) {
            throw new IllegalArgumentException("입력 값이 null 또는 빈 공백 입니다.");
        }
    }

    private List<Number> split(final String input) {

        return Arrays.stream(input.split(COMMA_EMPTY_STRING))
                .sorted()
                .map(number -> new Number(Integer.parseInt(number)))
                .collect(Collectors.toList());
    }

    public List<Number> getLottoNumber() {

        return Collections.unmodifiableList(this.lottoNumber);
    }

    @Override
    public String toString() {

        return "" + lottoNumber +"";
    }
}
