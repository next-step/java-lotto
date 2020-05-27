package lotto;

import java.util.List;

public class Lotto {

    public static final int PRICE = 1000;
    public static final int COUNT_OF_NUMBERS = 6;

    private List<Integer> numbers;

    public Lotto(LottoNumberSelectRule numberSelectRule) {
        this.numbers = numberSelectRule.select();
        validateCount(this.numbers.size());
    }

    public List<Integer> getNumbers() {
        return numbers;
    }

    public Rank checkResult(WinningNumbers winningNumbers) {
        validateCount(winningNumbers.size());

        long matchedCount = numbers.stream()
                .filter(winningNumbers::contains)
                .count();

        return Rank.findByMatchedCount(matchedCount);
    }

    private void validateCount(int count) {
        if (count != COUNT_OF_NUMBERS) {
            throw new IllegalArgumentException("숫자의 개수가 일치하지 않습니다");
        }
    }
}
