package lotto.domain;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class WinningPaper {
    private final List<Integer> winningNumbers;

    WinningPaper(String winningLottoNumbers) {
        this.winningNumbers = Arrays.stream(winningLottoNumbers.split(","))
                .map(String::trim)
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }

    Integer getMatchCount(List<Integer> lottoNumber) {
        return (int) lottoNumber.stream()
                .filter(winningNumbers::contains)
                .count();
    }
}
