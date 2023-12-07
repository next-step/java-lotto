package lotto.model;

import java.util.Arrays;
import java.util.function.Predicate;

public enum LottoRank {

    FIFTH(3, 5_000),
    FOURTH(4, 50_000),
    THIRD(5, 1_500_000),
    SECOND(5, 30_000_000),
    FIRST(6, 2_000_000_000),
    MISS(0, 0);


    private final long matchCount;
    private final int money;

    LottoRank(long rank, int money) {
        this.matchCount = rank;
        this.money = money;
    }

    public int money() {
        return this.money;
    }

    public long matchCount() {
        return this.matchCount;
    }

    private static LottoRank valueOf(long matchCount, boolean matchBonusNumber) {
        if (matchBonusNumber) {
            return matchRank(
                lottoRank -> lottoRank.matchCount() == matchCount && lottoRank == LottoRank.SECOND);
        }
        return matchRank(
            lottoRank -> lottoRank.matchCount() == matchCount && lottoRank != LottoRank.SECOND);
    }

    public static LottoRank rankByMatchCountAndBonusNumber(LottoNumbers lottoNumbers,
        WinningNumbers winningNumbers) {
        return LottoRank.valueOf(lottoNumbers.matchCount(winningNumbers),
            lottoNumbers.matchBonusNumber(winningNumbers));
    }

    private static LottoRank matchRank(Predicate<LottoRank> predicate) {
        return Arrays.stream(values())
            .filter(predicate)
            .findAny()
            .orElse(LottoRank.MISS);
    }

}
