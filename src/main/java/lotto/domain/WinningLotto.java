package lotto.domain;

import java.util.function.Predicate;

public class WinningLotto {

    private final Lotto winningLotto;
    private final int bonusNumber;

    public WinningLotto(Lotto winningNumbers, int bonusNumber) {
        if (winningNumbers.getNumbers().contains(bonusNumber)) {
            throw new IllegalArgumentException("중복된 번호는 입력할 수 없습니다.");
        }
        this.winningLotto = winningNumbers;
        this.bonusNumber = bonusNumber;
    }

    public Rank matchRank(Lotto lotto) {
        int count = (int) lotto.getNumbers().stream()
                .filter(n -> winningLotto.getNumbers().stream()
                        .anyMatch(Predicate.isEqual(n))).count();
        boolean bonusMatch = lotto.getNumbers().stream()
                .anyMatch(Predicate.isEqual(bonusNumber));

        return Rank.valueOf(count, bonusMatch);
    }
}
