package lotto.domain;

import java.util.List;

public class WinLotto extends Lotto {
    private final LottoNumber bonusNumber;
    public WinLotto(LottoNumberFactory factory, int bonusNumber) {
        super(factory);
        this.bonusNumber = new LottoNumber(bonusNumber);
    }

    public WinLotto(List<Integer> numbers, int bonusNumber) {
        super(numbers);
        this.bonusNumber = new LottoNumber(bonusNumber);
    }

    @Override
    public Rank matchCount(Lotto other) {
        Rank matchRank = super.matchCount(other);
        if ( matchRank == Rank.fiveNumbersMatch) {
            matchRank = rankWithBonusNumber(other);
        }
        return matchRank;
    }

    private Rank rankWithBonusNumber(Lotto other) {
        if (other.containsNumber(bonusNumber)) {
            return Rank.fiveNumbersMatchWithBonusNumber;
        }
        return  Rank.fiveNumbersMatch;
    }
}
