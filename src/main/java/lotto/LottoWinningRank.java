package lotto;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.function.Predicate;

public enum LottoWinningRank implements Comparable<LottoWinningRank>{
    NONE(0, matchedCount -> true),
    MATCHES_THREE(5_000, matchedCount -> matchedCount == 3),
    MATCHES_FOUR(50_000, matchedCount -> matchedCount == 4),
    MATCHES_FIVE(1_500_000, matchedCount -> matchedCount == 5),
    MATCHES_SIX(2_000_000_000, matchedCount -> matchedCount == 6);

    public static final String THERE_IS_NO_VALID_TYPE_ERR_MSG = "유효한 LottoWinningRank가 존재하지 않습니다.";
    private static final List<LottoWinningRank> LOTTO_WINNING_RANKS;
    static {
        LOTTO_WINNING_RANKS = Arrays.asList(LottoWinningRank.values());
        LOTTO_WINNING_RANKS.sort((r1, r2) -> Integer.compare(r2.winningAmount, r1.winningAmount));
    }

    private final int winningAmount;
    private final Predicate<Integer> checkWinning;

    LottoWinningRank(int winningAmount, Predicate<Integer> checkWinning) {
        this.winningAmount = winningAmount;
        this.checkWinning = checkWinning;
    }

    public static LottoWinningRank getWinningRank(Collection<Integer> winningNumbers, Collection<Integer> boughtLottoNumbers) {
        int matchCount = 0;
        for (Integer boughtLottoNumber : boughtLottoNumbers) {
            if (winningNumbers.contains(boughtLottoNumber)) {
                matchCount++;
            }
        }

        for (LottoWinningRank lottoWinningRank : LOTTO_WINNING_RANKS) {
            if (lottoWinningRank.checkWinning.test(matchCount)) {
                return lottoWinningRank;
            }
        }

        throw new IllegalStateException(THERE_IS_NO_VALID_TYPE_ERR_MSG);
    }
}
