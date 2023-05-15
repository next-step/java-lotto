package lotto.domain;

import java.util.*;
import java.util.stream.Collectors;

public class Lotto {
    private List<Integer> numbers = new ArrayList<>();

    public Lotto() {
        List<Integer> numbers = new ArrayList<>();
        for (int i = 1; i <= 45; i++) {
            numbers.add(i);
        }
        Collections.shuffle(numbers);
        this.numbers = numbers.subList(0, 6);
    }

    public Lotto(String numbers) {
        this(Arrays.stream(numbers.replace(" ", "").split(","))
                .map(Integer::parseInt)
                .collect(Collectors.toList()));
    }

    public Lotto(List<Integer> numbers) {
        numbers.stream()
                .filter(i -> i < 1 || i > 45)
                .findAny()
                .ifPresent(i -> {
                    throw new IllegalArgumentException("1부터 45까지의 숫자만 가질 수 있습니다.");
                });

        HashSet<Integer> set = new HashSet<>(numbers);
        if (set.size() != 6) {
            throw new IllegalArgumentException("중복되지 않는 6개의 숫자를 입력해주세요.");
        }

        this.numbers = new ArrayList<>(set);
    }

    public List<Integer> getNumbers() {
        return numbers;
    }

    public int matchedNumber(Lotto wonNumbers) {
        Set<Integer> lotto = new HashSet<>(numbers);
        lotto.retainAll(wonNumbers.numbers);
        return lotto.size();
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
}
