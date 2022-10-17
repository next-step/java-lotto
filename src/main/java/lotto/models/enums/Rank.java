package lotto.models.enums;

import lotto.models.Lotto;
import lotto.models.LottoNumbers;
import lotto.models.WinningLotto;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public enum Rank {

    FIRST(6, 2000000000, false),
    SECOND(5, 30000000, true),
    THIRD(5, 1500000, false),
    FOURTH(4, 50000, false),
    FIFTH(3, 5000, false),
    OTHER(0,  0, false);

    private final int equalCount;
    private final long amount;

    private final boolean hasBonusNumber;

    Rank(int equalCount, long amount, boolean hasBonusNumber) {
        this.equalCount = equalCount;
        this.amount = amount;
        this.hasBonusNumber = hasBonusNumber;
    }

    public int getEqualCount() {
        return equalCount;
    }

    public long getAmount() {
        return amount;
    }

    public static Rank findRank(WinningLotto winningLotto, Lotto targetLotto) {
        List<Integer> copiedWinningNumbers = new ArrayList<>(winningLotto.getNumbers());
        copiedWinningNumbers.retainAll(targetLotto.getNumbers());

        boolean hasBonusNumber = targetLotto.getNumbers().contains(winningLotto.getBonusNumber());
        return Rank.of(copiedWinningNumbers.size(), hasBonusNumber);
    }

    private static Rank of(int equalCount, boolean hasBonusNumber) {
        Optional<Rank> optionalRank = Arrays.stream(Rank.values())
                .filter(rank -> rank.equalCount == equalCount && rank.hasBonusNumber == hasBonusNumber)
                .findFirst();

        return optionalRank.orElse(OTHER);
    }
}
