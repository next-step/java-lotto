package lotto.domain;


import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class Lotto {

    public static final int PRICE = 1_000;
    public static final int SIZE = 6;
    public static final int MIN = 1;
    public static final int MAX = 45;

    private final List<LottoNumber> numbers;

    public Lotto(List<Integer> numbers) {
        validateNumbers(numbers);
        this.numbers = numbers.stream()
                .map(LottoNumber::new)
                .collect(Collectors.toList());
    }

    private void validateNumbers(List<?> numbers) {
        if (!isValidLottoSize(numbers)) {
            throw new IllegalArgumentException("여섯자리 번호를 입력해 주세요");
        }
        if (hasDuplicate(numbers)) {
            throw new IllegalArgumentException("로또 번호는 중복된 번호를 입력할 수 없습니다.");
        }
    }

    private boolean isValidLottoSize(List<?> numbers) {
        return numbers.size() == SIZE;
    }

    private boolean hasDuplicate(List<?> numbers) {
        return numbers.stream()
                .distinct()
                .count() != SIZE;
    }

    public int matchCountWith(Lotto other) {
        return (int) numbers.stream()
                .filter(other::contains)
                .count();
    }

    public boolean contains(LottoNumber number) {
        return numbers.contains(number);
    }

    public boolean matchBonus(LottoNumber bonusBall) {
        return numbers.contains(bonusBall);
    }

    public LottoNumber get(int index) {
        return numbers.get(index);
    }

    public List<LottoNumber> numbers() {
        return Collections.unmodifiableList(numbers);
    }

    public int size() {
        return numbers.size();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Lotto lotto = (Lotto) o;
        return numbers.equals(lotto.numbers);
    }

    @Override
    public int hashCode() {
        return Objects.hash(numbers);
    }
}
