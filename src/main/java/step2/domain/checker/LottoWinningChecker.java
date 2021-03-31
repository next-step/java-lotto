package step2.domain.checker;

import step2.domain.winning.WinningScore;
import step2.domain.lotto.Lotto;
import step2.domain.lotto.Lottos;
import step2.domain.winning.WinningScoreBoard;

import java.util.EnumMap;
import java.util.List;

public final class LottoWinningChecker {

    private final Lotto WinningLotto;

    private LottoWinningChecker(Lotto WinningLotto) {
        this.WinningLotto = WinningLotto;
    }

    public static final LottoWinningChecker of(Lotto WinningLotto) {
        return new LottoWinningChecker(WinningLotto);
    }

    public final WinningScoreBoard getLottoWinningResultResponseDto(Lottos lottos) {
        List<Lotto> lottoList = lottos.getLottos();
        WinningScoreBoard winningScoreBoard = WinningScoreBoard.of(new EnumMap<>(WinningScore.class));
        for (Lotto lotto : lottoList) {
            int correctCount = lotto.getCorrectCount(WinningLotto);
            WinningScore winningScore = WinningScore.valueOf(correctCount);
            winningScoreBoard.increaseCount(winningScore);
        }
        return winningScoreBoard;
    }

}
