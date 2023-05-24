package autolotto.machine.lotto;

import autolotto.machine.winning.WinningNumbers;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Lotto {
    private static final int LOTTO_NUMBER_COUNT = 6;

    private final List<LottoNumber> numbers;

    public Lotto(List<LottoNumber> numbers) {
        checkCountOfNumbers(numbers);
        this.numbers = new ArrayList<>(numbers);
    }

    private void checkCountOfNumbers(List<LottoNumber> numbers) {
        if(numbers.size() != LOTTO_NUMBER_COUNT) {
            throw new IllegalArgumentException("로또는 6개의 수로 이루어져야 합니다");
        }
    }

    public int matchCount(WinningNumbers comparisonTarget) {
        ArrayList<LottoNumber> winningNumbers = new ArrayList<>(comparisonTarget.winningNumbers());
        winningNumbers.sort(Comparator.comparing(LottoNumber::value));

        return (int) winningNumbers.stream()
                .filter(this.numbers::contains)
                .count();
    }

    public int size() {
        return this.numbers.size();
    }

    public List<LottoNumber> lottoNumbers() {
        return new ArrayList<>(this.numbers);
    }

    public boolean contains(int number) {
        return numbers.contains(new LottoNumber(number));
    }
}
