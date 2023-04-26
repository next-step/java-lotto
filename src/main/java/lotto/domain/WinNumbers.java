package lotto.domain;

import java.util.HashSet;
import java.util.List;
import java.util.stream.Collectors;

import static lotto.domain.Lotto.LOTTO_SIZE;

public class WinNumbers {
    private final List<Number> numbers;
    private final Number bonusNumber;

    public WinNumbers(List<Integer> numbers, Number bonusNumber) {
        if (new HashSet<>(numbers).size() != LOTTO_SIZE) {
            throw new IllegalArgumentException("당첨번호 중복없이 6개가 필요합니다.");
        }

        this.numbers = numbers.stream().map(Number::new).sorted().collect(Collectors.toList());
        this.bonusNumber = bonusNumber;
    }

    public WinType confirmWin(Lotto lotto) {
        long count = lotto.matchNumber(this.numbers);
        long bonusCount = lotto.matchBonusNumber(this.bonusNumber);
        return WinType.find(count, bonusCount);
    }
}
