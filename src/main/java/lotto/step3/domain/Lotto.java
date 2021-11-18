package lotto.step3.domain;

import java.util.List;

public class Lotto {

    public static final int LOTTO_BONUS_COUNT = Rank.SECOND.getCountOfMatch();
    private static final int LOTTO_SIZE = Rank.FIRST.getCountOfMatch();

    private final List<Integer> numbers;

    public Lotto() {
       this.numbers = RandomNumbers.createRandomNumber();
    }

    public Lotto(List<Integer> numbers) {
        if (numbers.size() != LOTTO_SIZE) {
            throw new IllegalArgumentException();
        }
        this.numbers = numbers;
    }

    public List<Integer> getNumbers() {
        return numbers;
    }

    public boolean isCountOfMatch(Lotto winningNumbers, int count) {
        return numbers.stream()
                .filter(winningNumbers.getNumbers()::contains)
                .count() == count;
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

    private boolean isLottoBonusCount(Lotto winningNumbers) {
        return numbers.stream()
                .filter(number -> winningNumbers.getNumbers().contains(number))
                .count() == LOTTO_BONUS_COUNT;
    }

    private boolean hasBonusBall(int bonusBall) {
        return numbers.contains(bonusBall);
    }

}
