package lotto.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class WinningNumber {
    List<Integer> winningNumbers;

    public WinningNumber(String winningNumbersValue) {
        List<Integer> winningNumbers = new ArrayList<>(Parser.numbersParsing(winningNumbersValue));
        validationCheck(winningNumbers);
        this.winningNumbers = winningNumbers;
    }

    public boolean contains(int value) {
        return winningNumbers.contains(value);
    }

    public int correctCount(List<Integer> values) {
        return values.stream()
                .filter(value -> this.winningNumbers.contains(value))
                .collect(Collectors.toList())
                .size();
    }

    private void validationCheck(List<Integer> list) {
        if (numberRangeCheck(list)) {
            throw new IllegalArgumentException("번호중 숫자 범위를 벗어나는 수가 있습니다. 숫자범위 : 1~45");
        }
        if (duplicationCheck(list)) {
            throw new IllegalArgumentException("당첨 번호에 중복이 있습니다.");
        }
    }

    private boolean numberRangeCheck(List<Integer> list) {
        return list.stream().anyMatch(value -> value < Lotto.START_NUMBER || value > Lotto.END_NUMBER);
    }

    private boolean duplicationCheck(List<Integer> list) {
        return list.stream().distinct().count() != list.size();
    }
}
