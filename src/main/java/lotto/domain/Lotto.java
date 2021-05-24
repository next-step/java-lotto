package lotto.domain;


import java.util.Collections;
import java.util.List;

public class Lotto {

    public static final int PRICE = 1_000;
    public static final int SIZE = 6;
    public static final int MIN = 1;
    public static final int MAX = 45;

    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validateNumbers(numbers);
        this.numbers = numbers;
    }

    private void validateNumbers(List<Integer> numbers) {
        if (!isValidLottoSize(numbers)) {
            throw new IllegalArgumentException("여섯자리 번호를 입력해 주세요");
        }
        if (hasDuplicate(numbers)) {
            throw new IllegalArgumentException("로또 번호는 중복된 번호를 입력할 수 없습니다.");
        }
        if (containsInvalidNumber(numbers)) {
            throw new IllegalArgumentException("로또 번호는 1에서 45사이의 숫자값만 입력할 수 있습니다.");
        }
    }

    private boolean isValidLottoSize(List<Integer> numbers) {
        return numbers.size() == Lotto.SIZE;
    }

    private boolean hasDuplicate(List<Integer> numbers) {
        return numbers.stream()
                .distinct()
                .count() != Lotto.SIZE;
    }

    private boolean containsInvalidNumber(List<Integer> numbers) {
        return numbers.stream()
                .anyMatch(this::isInValidNumber);
    }

    private boolean isInValidNumber(int number) {
        return !(number >= MIN && number <= MAX);
    }


    public int matchCountWith(Lotto other) {
        return (int) numbers.stream()
                .filter(other::contains)
                .count();
    }

    public boolean contains(Integer number) {
        return numbers.contains(number);
    }

    public boolean matchBonus(int bonusBall) {
        return numbers.contains(bonusBall);
    }

    public int get(int index) {
        return numbers.get(index);
    }

    public List<Integer> numbers() {
        return Collections.unmodifiableList(numbers);
    }

    public int size() {
        return numbers.size();
    }
}
