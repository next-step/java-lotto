package im.juniq.lotto.domain;

import java.util.List;

public class LottoNumbers {
    private final List<Integer> numbers;

    public LottoNumbers(List<Integer> numbers) {
        this.numbers = numbers;
    }

    public int matchedCount(LottoNumbers paramLottoNumbers) {
        return numbers.stream().mapToInt(paramLottoNumbers::contain).sum();
    }

    private int contain(int number) {
        if (numbers.contains(number)) {
            return 1;
        }
        return 0;
    }
}
