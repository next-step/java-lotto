package lotto.domain;

import java.util.Collections;
import java.util.List;

public class LottoNumbersWrapper {
    private final List<Integer> numbers;

    public LottoNumbersWrapper(List<Integer> numbers) {
        this.numbers = numbers;
    }

    public List<Integer> getNumbers() {
        return Collections.unmodifiableList(numbers);
    }

    public boolean contains(Integer number) {
        return this.numbers.contains(number);
    }

    public int getMatchCount(LottoNumbersWrapper collectNumberList) {
        int matchCount = 0;
        for (int number : this.numbers) {
            matchCount += getMatchCount(collectNumberList, number);
        }
        return matchCount;
    }

    public boolean isMatchToBonusNumber(int bonusNumber) {
        return this.numbers.contains(bonusNumber);
    }

    private int getMatchCount(LottoNumbersWrapper lottoNumbersWrapper, int number) {
        if (lottoNumbersWrapper.contains(number)) {
            return 1;
        }
        return 0;
    }
}
