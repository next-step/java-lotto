package lotto.domain;

import java.util.List;
import java.util.stream.Collectors;

public class WinningNumbers {

    private final List<WinningNumber> winningNumbers;

    private WinningNumbers(List<WinningNumber> winningNumbers) {
        this.winningNumbers = winningNumbers;
    }

    public static WinningNumbers of(List<Integer> winningNumbers) {
        return new WinningNumbers(winningNumbers.stream()
                .map(WinningNumber::new)
                .collect(Collectors.toUnmodifiableList()));
    }

    public int countMatchingWith(LottoNumbers lottoNumbers) {
        return Math.toIntExact(this.winningNumbers.stream()
                .map(WinningNumber::number)
                .filter(lottoNumbers::isContains)
                .count());
    }

}
