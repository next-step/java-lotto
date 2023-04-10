package lotto;

import configuration.WinnerType;

import static configuration.LottoConfiguration.*;

public class LottoGame {
    private static WinnerType winnerType;

    public static WinnerType match(Lotto userLotto, WinningLotto winningLotto) {
        int matchingCount = (int) userLotto
                .getLottoNumbers()
                .stream()
                .filter(it ->
                        winningLotto.getWinningNumber().getLottoNumbers().contains(it))
                .count();
        boolean bonusMatch = userLotto
                .getLottoNumbers()
                .contains(winningLotto.getBonusNumber());
        return LottoGame.winningCheck(matchingCount, bonusMatch);
    }

    public static WinnerType winningCheck(int matchingCount, boolean bonusMatch) {
        if (matchingCount == FIRST_MATCHING_COUNT) {
            return winnerType.FIRST;
        }
        if (matchingCount == SECOND_OR_THIRD_MATCHING_COUNT && bonusMatch) {
            return winnerType.SECOND;
        }
        if (matchingCount == SECOND_OR_THIRD_MATCHING_COUNT) {
            return winnerType.THIRD;
        }
        if (matchingCount == FORTH_MATCHING_COUNT) {
            return winnerType.FORTH;
        }
        if (matchingCount == FIFTH_MATCHING_COUNT) {
            return winnerType.FIFTH;
        }
        return winnerType.NONE;
    }
}
