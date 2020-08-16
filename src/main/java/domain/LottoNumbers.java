package domain;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class LottoNumbers {
    private final Set<Number> winningNumbers;

    public LottoNumbers(Set<Number> numbers) {
        validate(numbers);
        this.winningNumbers = numbers;
    }

    private void validate(Set<Number> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException("당첨 번호는 6개의 다른 값 이여야 합니다.");
        }
    }

    public Rank getRank(LottoNumbers lottoWinningNumbers) {
        List<Number> collect = lottoWinningNumbers.winningNumbers.stream()
                .filter(winningNumbers::contains)
                .collect(Collectors.toList());

        return Rank.getRank(collect.size());
    }

    @Override public String toString() {
        return winningNumbers.toString();
    }
}
