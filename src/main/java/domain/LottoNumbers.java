package domain;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class LottoNumbers {
    private final Set<Number> winningNumbers;

    public LottoNumbers(List<Number> winningNumbers) {
        this.winningNumbers = new HashSet<>(winningNumbers);
        validate();
    }

    private void validate() {
        if (this.winningNumbers.size() != 6) {
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
