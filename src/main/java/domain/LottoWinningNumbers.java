package domain;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class LottoWinningNumbers {
    private final List<Integer> winningNumbers;

    public LottoWinningNumbers(List<Integer> winningNumbers) {
        Set<Integer> set = new HashSet<>(winningNumbers);
        if (set.size() != 6) {
            throw new IllegalArgumentException("당첨 번호는 6개의 다른 값 이여야 합니다.");
        }
        this.winningNumbers = winningNumbers;
    }

    public LottoWinningType getWinningType(LottoNumbers lottoNumbers) {
        List<Integer> collect = lottoNumbers.getNumbers().stream()
                .filter(winningNumbers::contains)
                .collect(Collectors.toList());

        return LottoWinningType.getWinningType(collect.size());
    }
}
