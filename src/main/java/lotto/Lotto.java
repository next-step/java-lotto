package lotto;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

/**
 * Lotto 는 6개의 LottoNumber List 형태로 가지고 있다.
 * Lotto 는 LottoResult 와 협력하여 몇개 맞추었는지 알 수 있다.
 * Lotto 는 LottoResult 와 협력하여 보너스 볼을 맞추었는지 알 수 있다.
 */
public class Lotto {
    private static final String DELIMITER = ", ";
    private static final int DEFAULT_CHOICE_COUNT = 6;

    private final List<LottoNumber> numbers;

    /**
     * 인자를 받지 않은 경우
     * LottoGenerator.auto() 를 통해 번호를 가져와 default 생성자에 위임한다.
     */
    public Lotto() {
        this(LottoGenerator.auto());
    }

    /**
     * String 을 인자로 받은 경우
     * List<LottoNumber>로 변환하여 default 생성자에 위임한다.
     * @param numbers
     */
    public Lotto(String numbers) {
        this(Arrays.stream(numbers.split(DELIMITER))
                .map(LottoNumber::new)
                .collect(Collectors.toList())
        );
    }

    /**
     * @DEFAULT_CONSTRUCTOR
     * numbers 를 갖는 Lotto 객체를 생성한다.
     * @param numbers
     */
    public Lotto(List<LottoNumber> numbers) {
        validateNumbersCount(numbers);

        this.numbers = numbers;
    }

    /**
     * numbers 의 size 가 DEFAULT_CHOICE_COUNT 와 일치하지 않다면 예외를 던진다.
     * @param numbers
     */
    private void validateNumbersCount(List<LottoNumber> numbers) {
        if (numbers.size() != DEFAULT_CHOICE_COUNT) {
            throw new IllegalArgumentException("로또는 6개의 번호를 선택해야 합니다.");
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Lotto lotto = (Lotto) o;
        return Objects.equals(numbers, lotto.numbers);
    }

    @Override
    public int hashCode() {
        return Objects.hash(numbers);
    }

    @Override
    public String toString() {
        return numbers.toString();
    }

    public int compare(Lotto target) {
        return (int) target.numbers.stream()
                .filter(this.numbers::contains)
                .count();
    }

    public boolean hasBonus(LottoNumber bonusNumber) {
        return this.numbers.contains(bonusNumber);
    }
}
