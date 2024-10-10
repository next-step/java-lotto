package lotto.domain;

import java.util.*;

public class Lotto {
    private static final int MAX_GENERATE_COUNT = 6;
    private static final int MAX_NUMBER = 45;

    private final Set<LottoNumber> numbers;

    public Lotto() {
        this.numbers = new TreeSet<>();
        numbers.addAll(getShuffleNumbers());
    }

    public Lotto(final Set<LottoNumber> numbers) {
        validateInitLotto(numbers);
        this.numbers = new TreeSet<>(numbers);
    }

    private Set<LottoNumber> getShuffleNumbers() {
        List<LottoNumber> allNumbers = new ArrayList<>();
        for (int i = 1; i <= MAX_NUMBER; i++) {
            allNumbers.add(LottoNumber.valueOf(i));
        }
        Collections.shuffle(allNumbers);

        return new HashSet<>((allNumbers.subList(0, MAX_GENERATE_COUNT)));
    }

    private void validateInitLotto(final Set<LottoNumber> numbers) {
        validateNumberSize(numbers);
    }

    private void validateNumberSize(final Set<LottoNumber> numbers) {
        if (numbers.size() != MAX_GENERATE_COUNT) {
            throw new IllegalArgumentException("로또번호의 개수가 일치하지 않습니다.");
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

    @Override
    public String toString() {
        return Arrays.toString(numbers.toArray());
    }
}
