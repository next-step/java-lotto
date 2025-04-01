package lotto.domain;

import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Lotto {
    public static final int NUMBER_COUNT = 6;
    private final List<LottoNumber> numbers;

    public Lotto(List<LottoNumber> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<LottoNumber> numbers) {
        if (numbers == null || numbers.isEmpty()) {
            throw new IllegalArgumentException("번호가 지정되지 않았습니다.");
        }
        if (numbers.size() != NUMBER_COUNT) {
            throw new IllegalArgumentException("6개의 번호가 지정되어야 합니다.");
        }
        if (hasDuplicates(numbers)) {
            throw new IllegalArgumentException("중복된 번호가 있습니다.");
        }
    }

    private boolean hasDuplicates(List<LottoNumber> numbers) {
        HashSet<LottoNumber> filteredNumbers = new HashSet<>(numbers);
        return numbers.size() != filteredNumbers.size();
    }

    public List<LottoNumber> numbers() {
        return Collections.unmodifiableList(numbers);
    }

    public MatchCount match(WinningNumbers winningNumbers) {
        List<LottoNumber> numbers = winningNumbers.numbers();
        long matchCount = this.numbers.stream()
                .filter(numbers::contains)
                .count();
        return new MatchCount(matchCount);
    }
}
