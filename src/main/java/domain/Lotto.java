package domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;

public class Lotto {

    private final List<Integer> numbers;

    public Lotto() {
        this(createNumbers());
    }

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        for (Integer number : numbers) {
            validateRange(number);
        }

        if (numbers.size() != 6) {
            throw new IllegalArgumentException("로또는 6개의 숫자가 생성되어야한다.");
        }

        if (new HashSet<>(numbers).size() != numbers.size()) {
            throw new IllegalArgumentException("로또 번호는 중복될 수 없다.");
        }
    }

    private void validateRange(Integer number) {
        if (number <= 0 || number > 45) {
            throw new IllegalArgumentException("1부터 45까지의 로또만 생성이 가능하다.");
        }
    }

    private static List<Integer> createNumbers() {
        List<Integer> candidates = new ArrayList<>();
        for (int i = 1; i <= 45; i++) {
            candidates.add(i);
        }
        Collections.shuffle(candidates);
        List<Integer> numbers = new ArrayList<>(candidates.subList(0, 6));
        Collections.sort(numbers);
        return numbers;

    }


    public List<Integer> getNumbers() {
        return Collections.unmodifiableList(numbers);
    }


    public int match(WinningNumber winningNumber) {
        return (int) numbers.stream()
                .filter(winningNumber::contains)
                .count();
    }
}
