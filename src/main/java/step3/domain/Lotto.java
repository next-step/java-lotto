package step3.domain;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Lotto {

    public static final int MAX_NUMBER = 6;

    private final List<LottoNo> numbers;

    public Lotto(int ... nos) {
        this(Arrays.stream(nos)
                .boxed()
                .map(LottoNo::new)
                .collect(Collectors.toList()));
    }

    public Lotto(List<LottoNo> numbers) {
        if (numbers.size() != MAX_NUMBER) {
            throw new IllegalArgumentException("로또번호는 6개여야 합니다.");
        }
        Collections.sort(numbers);
        this.numbers = numbers;
    }

    private int findWinningNumbersCount(WinningNumbers winningNumbers) {
        return (int) numbers.stream()
                .filter(winningNumbers::isWinningNumber)
                .count();
    }

    private boolean isMatchBonus(WinningNumbers winningNumbers) {
        return numbers.stream()
                .anyMatch(winningNumbers::isMatchBonus);
    }

    public Rank getRank(WinningNumbers winningNumbers) {
        int winningNumbersCount = findWinningNumbersCount(winningNumbers);
        boolean matchBonus = isMatchBonus(winningNumbers);
        return Rank.valueOf(winningNumbersCount, matchBonus);
    }

    @Override
    public String toString() {
        return numbers.toString();
    }

}
