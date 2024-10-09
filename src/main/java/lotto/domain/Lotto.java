package lotto.domain;

import java.util.*;

public class Lotto {
    private static final int MAX_NUMBER = 45;
    private static final int MAX_GENERATE_COUNT = 6;

    private final Set<Integer> numbers;

    public Lotto() {
        this.numbers = new TreeSet<>();
        issue();
    }

    public Lotto(final Set<Integer> numbers) {
        validateInitLotto(numbers);
        this.numbers = new TreeSet<>(numbers);
    }

    private void validateInitLotto(final Set<Integer> numbers) {
        validateNumberSize(numbers);
        validateNumbers(numbers);
    }

    private void validateNumbers(final Set<Integer> numbers) {
        numbers.forEach(this::validateNumber);
    }

    private void validateNumberSize(final Set<Integer> numbers) {
        if (numbers.size() != MAX_GENERATE_COUNT) {
            throw new IllegalArgumentException("로또번호의 개수가 일치하지 않습니다.");
        }
    }

    private void validateNumber(final int lottoNumber) {
        if (lottoNumber < 1 || lottoNumber > MAX_NUMBER) {
            throw new IllegalArgumentException("올바른 로또 번호가 아닙니다.(1이상 45이하 아님)");
        }
    }

    public int getMatchingNumberCount(final Lotto lotto) {
        if (lotto == null) {
            return 0;
        }
        return (int) numbers.stream()
                .filter(lotto.numbers::contains)
                .count();
    }

    private void issue() {
        numbers.addAll(getShuffleNumbers());
    }

    private Set<Integer> getShuffleNumbers() {
        List<Integer> allNumbers = new ArrayList<>();
        for (int i = 1; i <= MAX_NUMBER; i++) {
            allNumbers.add(i);
        }
        Collections.shuffle(allNumbers);
        return new HashSet<>(allNumbers.subList(0, MAX_GENERATE_COUNT));
    }

    @Override
    public String toString() {
        return Arrays.toString(numbers.toArray());
    }
}
