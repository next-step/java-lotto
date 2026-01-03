package lotto;

import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public record Lotto(Set<LottoNumber> numbers) {
    public static final int LOTTO_COUNT = 6;

    public Lotto(int... numbers) {
        this(toSet(numbers));
    }

    public Lotto(List<Integer> numbers) {
        this(numbers.stream()
                .mapToInt(Integer::intValue)
                .toArray());
    }

    public Lotto {
        validate(numbers);
    }

    @Override
    public Set<LottoNumber> numbers() {
        return numbers;
    }

    public int matchCount(Lotto lotto) {
        return (int) numbers.stream()
                .filter(lotto.numbers()::contains)
                .count();
    }

    public LottoRank rank(WinningLotto winningLotto) {
        int matchCount = matchCount(winningLotto.lotto());
        boolean bonusMatch = winningLotto.matchBonusNumber(this);
        return LottoRank.valueOf(matchCount, bonusMatch);
    }

    private static Set<LottoNumber> toSet(int... numbers) {
        return Arrays.stream(numbers)
                .boxed()
                .sorted()
                .map(LottoNumber::new)
                .collect(Collectors.toCollection(LinkedHashSet::new));
    }

    private void validate(Set<LottoNumber> numbers) {
        if (numbers.size() != LOTTO_COUNT) {
            throw new IllegalArgumentException("로또 번호는 6개여야 합니다.");
        }
    }

    @Override
    public String toString() {
        return numbers.stream()
                .map(LottoNumber::value)
                .map(String::valueOf)
                .collect(Collectors.joining(", ", "[", "]"));
    }
}
