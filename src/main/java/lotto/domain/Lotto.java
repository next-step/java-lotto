package lotto.domain;

import java.util.*;
import java.util.stream.Collectors;

public class Lotto {

    public static final int LOTTO_NUMBER_COUNT = 6;
    private static final String DELIMITER = ", ";

    private final List<Number> lotto;

    public Lotto(final List<Number> lotto) {

        this.lotto = lotto;
    }

    public static Lotto from(final String input) {

        final List<Number> lottoNumbers = split(input);
        validateSize(lottoNumbers);

        return new Lotto(lottoNumbers);
    }

    public static Lotto from(final List<Integer> lottoNumber) {

        return new Lotto(convert(lottoNumber));
    }

    private static List<Number> split(final String input) {

        return Arrays.stream(input.split(DELIMITER))
                .sorted()
                .map(number -> new Number(Integer.parseInt(number)))
                .collect(Collectors.toList());
    }

    private static void validateSize(final List<Number> lottoNumbers) {

        final Set<Number> numbers = new HashSet<>(lottoNumbers);
        if (numbers.size() != LOTTO_NUMBER_COUNT) {
            throw new IllegalArgumentException("6개의 숫자를 입력해야 하며 중복 숫자는 입력할 수 없습니다.");
        }
    }

    private static List<Number> convert(final List<Integer> numbers) {

        return numbers.stream()
                .map(Number::new)
                .collect(Collectors.toList());
    }

    public List<Number> getLotto() {

        return Collections.unmodifiableList(this.lotto);
    }

    @Override
    public boolean equals(Object o) {

        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Lotto lotto1 = (Lotto) o;
        return Objects.equals(lotto, lotto1.lotto);
    }

    @Override
    public int hashCode() {

        return Objects.hash(lotto);
    }
}
