package lotto.models.enums;

import lotto.models.Lotto;
import lotto.models.LottoNumbers;
import lotto.models.WinningLotto;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public enum Rank {

    FIRST(6, 2000000000),
    SECOND(5, 1500000),
    THIRD(4, 50000),
    FOURTH(3, 5000),
    OTHER(0,  0);

    private final int equalCount;
    private final long amount;

    Rank(int equalCount, long amount) {
        this.equalCount = equalCount;
        this.amount = amount;
    }

    public int getEqualCount() {
        return equalCount;
    }

    public long getAmount() {
        return amount;
    }

    public static Rank findRank(WinningLotto winningLotto, Lotto targetLotto) {
        List<Integer> copiedWinningNumbers = new ArrayList<>(winningLotto.getLottoNumbers().getNumbers());

        copiedWinningNumbers.retainAll(targetLotto.getLottoNumbers().getNumbers());
        return Rank.of(copiedWinningNumbers.size());
    }

    private static Rank of(int equalCount) {
        Optional<Rank> optionalRank = Arrays.stream(Rank.values())
                .filter(rank -> rank.equalCount == equalCount)
                .findFirst();

        return optionalRank.orElse(OTHER);
    }
}
