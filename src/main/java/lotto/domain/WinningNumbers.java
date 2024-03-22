package lotto.domain;

import java.util.List;

public class WinningNumbers {

    private final List<WinningNumber> winningNumbers;

    public WinningNumbers(List<WinningNumber> winningNumbers) {
        this.winningNumbers = winningNumbers;
    }

    //todo : countMatchingWith 메서드 구현
//    public int countMatchingWith(List<Integer> lottoNumbers) {
//        return Math.toIntExact(this.winningNumbers.stream()
//                .map(WinningNumber::number)
//                .filter(lottoNumbers::contains)
//                .count());
//    }
}
