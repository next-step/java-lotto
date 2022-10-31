package lotto.domain;

import java.util.List;

public class WinningNumber {
    private final List<Integer> numbers;
    private final Integer bonusNumber;

    public WinningNumber(List<Integer> numbers, Integer bonusNumber) {
        this.numbers = numbers;
        this.bonusNumber = bonusNumber;
    }

    public Rank calcLottoRankWithBonus(Lotto lotto) {
        Rank rank = new Rank();
        lotto.calculateRank(this, rank);
        return rank;
    }

    void calculateRank(LottoNumber lottoNumber, Rank rank) {
        int matchingNumberCount = lottoNumber.findMatchingNumberCount(numbers);
        boolean containBonusNumber = lottoNumber.isContainBonusNumber(bonusNumber);
        rank.settingRank(matchingNumberCount, containBonusNumber);
    }
}
