package lotto.domain;

import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Lotto {

    private static final String DELIMITER = ",";
    public static final int LOTTO_NUMBER_SIZE = 6;

    private final List<LottoNumber> lotto;

    private Lotto(List<LottoNumber> lotto) {
        this.lotto = Collections.unmodifiableList(lotto);
    }

    public static Lotto create() {
        return new Lotto(LottoGenerator.generate());
    }

    public static Lotto of(String lottoNumberString) {
        String[] numbers = Objects.requireNonNull(lottoNumberString).split(DELIMITER);
        validateNumbers(numbers);

        return new Lotto(Stream.of(numbers)
                .map(str -> LottoNumber.of(Integer.parseInt(str.trim())))
                .collect(Collectors.toList()));
    }

    private static void validateNumbers(String[] numbers) {
        if (Stream.of(numbers).map(String::trim).anyMatch(String::isBlank)
                || numbers.length != LOTTO_NUMBER_SIZE) {
            throw new IllegalArgumentException("6개 숫자를 입력하셔야 합니다.");
        }

        if (Stream.of(numbers).map(String::trim).distinct().count() != numbers.length) {
            throw new IllegalArgumentException("중복된 숫자가 존재합니다.");
        }
    }

    public Stream<LottoNumber> stream() {
        return lotto.stream();
    }

    @Override
    public String toString() {
        return lotto.toString();
    }
}
