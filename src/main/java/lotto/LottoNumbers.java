package lotto;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class LottoNumbers {
    private final List<LottoNumber> numbers;

    public LottoNumbers(List<LottoNumber> numbers) {
        this.numbers = numbers;
    }

    public void shuffleNumbers() {
        Collections.shuffle(numbers);
    }

    public LottoNumbers selectNumbers(int count) {
        return new LottoNumbers(numbers.subList(0, count)
                .stream()
                .sorted()
                .collect(Collectors.toList()));
    }

    public int winningCount(LottoNumbers winningNumbers) {
        int count = 0;

        for (LottoNumber lottoNumber: winningNumbers.numbers) {
            if (this.numbers.contains(lottoNumber)) {
                count++;
            }
        }
        return count;
    }

    @Override
    public String toString() {
        return "[ " + this.numbers.stream()
                .map(LottoNumber::toString)
                .collect(Collectors.joining(", "))
                + " ]";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        LottoNumbers that = (LottoNumbers) o;
        return this.numbers.containsAll(that.numbers);
    }
}
