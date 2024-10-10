package lotto;

import java.util.HashSet;
import java.util.Set;

public class WinningNumbers {
    private final Set<Integer> winningNumbers;

    public WinningNumbers(Set<Integer> winningNumbers) {
        if (winningNumbers == null || winningNumbers.isEmpty()) {
            throw new IllegalArgumentException("당첨번호는 null 이거나 비어있을 수 없습니다");
        }
        this.winningNumbers = winningNumbers;
    }

    public int equalNumberCount(Set<Integer> lottoNumbers) {
        Set<Integer> equalNumbers = new HashSet<>(winningNumbers);
        equalNumbers.retainAll(lottoNumbers);

        return equalNumbers.size();
    }
}
