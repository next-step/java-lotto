package lotto.step3.domain;

import java.util.ArrayList;
import java.util.List;

public class Lotto {

    public static final int LOTTO_BONUS_COUNT = 5;
    private static final int LOTTO_SIZE = 6;

    private List<Integer> numbers = new ArrayList<>();

    private Lotto() {}

    public Lotto(List<Integer> numbers) {
        checkNumbers(numbers);
        this.numbers = numbers;
    }

    public List<Integer> getNumbers() {
        return numbers;
    }

    public boolean isCountOfMatch(Lotto winningNumbers, int count) {
        return countOfMatch(winningNumbers) == count;
    }

    public boolean isSecondPrizeWinner(Lotto winningNumbers, int bonusBall) {
        return isLottoBonusCount(winningNumbers) && hasBonusBall(bonusBall);
    }

    public int calculatePrizeMoney(Lotto winningNumbers, int bonusBall) {
        int count = (int) numbers.stream()
                .filter(number -> winningNumbers.getNumbers().contains(number))
                .count();
        return Rank.valueOf(count, isSecondPrizeWinner(winningNumbers,bonusBall)).getPrizeMoney();
    }

    private long countOfMatch(Lotto winningNumbers) {
        return numbers.stream()
                .filter(winningNumbers.getNumbers()::contains)
                .count();
    }

    private boolean isLottoBonusCount(Lotto winningNumbers) {
        return numbers.stream()
                .filter(number -> winningNumbers.getNumbers().contains(number))
                .count() == LOTTO_BONUS_COUNT;
    }

    private boolean hasBonusBall(int bonusBall) {
        return numbers.contains(bonusBall);
    }

    private void checkNumbers(List<Integer> numbers) {
        if (numbers.size() != LOTTO_SIZE) {
            throw new IllegalArgumentException("6자리 입력해주세요");
        }
        long count = numbers.stream()
                .mapToInt(n -> n)
                .distinct()
                .count();
        if (count != LOTTO_SIZE) {
            throw new IllegalArgumentException("중복 번호는 안됩니다");
        }
    }

}
