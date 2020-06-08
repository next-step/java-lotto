package lotto.domain;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class WinningNumber {
    private final List<LottoNumber> winningNumbers;

    public WinningNumber(String[] inputNumbers) {
        this.winningNumbers = convertToLottoNumber(inputNumbers);
    }

    private List<LottoNumber> convertToLottoNumber(String[] inputNumbers) {
        if(inputNumbers.length != 6) {
           throw new IllegalArgumentException("당첨 숫자가 부족합니다.");
        }
        return Stream.of(inputNumbers)
                .map(Integer::parseInt)
                .map(LottoNumber::valueOf)
                .collect(Collectors.toList());
    }

    public List<LottoNumber> getWinningNumbers() {
        return winningNumbers;
    }
}
