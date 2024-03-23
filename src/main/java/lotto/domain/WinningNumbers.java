package lotto.domain;

import java.util.List;
import java.util.stream.Collectors;

public class WinningNumbers { // 당첨 번호들을 담당하는 객체

    private final List<WinningNumber> winningNumbers;

    private WinningNumbers(List<WinningNumber> winningNumbers) {
        this.winningNumbers = winningNumbers;
    }

    public static WinningNumbers of(List<Integer> winningNumbers) {
        return new WinningNumbers(winningNumbers.stream()
                .map(WinningNumber::new)
                .collect(Collectors.toUnmodifiableList()));
    }

    public int countMatchingWith(List<Integer> lottoNumbers) {
        return Math.toIntExact(lottoNumbers.stream()
                .map(WinningNumber::new)
                .filter(winningNumbers::contains)
                .count());
    }
}
