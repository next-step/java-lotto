package lotto.domain;

import java.util.List;
import java.util.stream.Collectors;

public class WinNumbers {
    private final List<Number> numbers;
    private final Number bonusNumber;

    public WinNumbers(List<Integer> numbers, int bonusNumber) {
        this.numbers = numbers.stream().map(Number::new).sorted().collect(Collectors.toList());
        this.bonusNumber = new Number(bonusNumber);
    }

    public WinType confirmWin(Lotto lotto) {
        long count = lotto.match(this.numbers);
        return WinType.find(count);
    }
}
