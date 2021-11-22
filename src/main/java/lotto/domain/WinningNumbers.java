package lotto.domain;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static lotto.domain.Lotto.SIZE;

public class WinningNumbers {

    private List<Number> winningNumbers;

    public WinningNumbers(List<Number> winningNumbers) {
        checkSize(winningNumbers);
        this.winningNumbers = winningNumbers;
    }

    public WinningNumbers(String winningNumbersString) {
        List<Number> winningNumbers = Arrays.asList(winningNumbersString.split(",")).stream()
                .map(Integer::parseInt)
                .map(integer -> new Number(integer))
                .collect(Collectors.toList());
        checkSize(winningNumbers);
        this.winningNumbers = winningNumbers;
    }

    private void checkSize(List<Number> winningNumbers) {
        if (winningNumbers.size() != SIZE) {
            throw new IllegalArgumentException(SIZE + " 와 길이가 다른 winningNumbers 는 입력될 수 없습니다.");
        }
    }

    public boolean checkContainNumber(Number number) {
        return winningNumbers.contains(number);
    }

}
