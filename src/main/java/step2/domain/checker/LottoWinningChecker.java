package step2.domain.checker;

import step2.domain.winning.WinningScore;
import step2.domain.lotto.Lotto;
import step2.domain.lotto.Lottos;
import step2.domain.winning.WinningScoreBoard;
import step2.dto.LottoWinningCheckRequestDto;
import step2.dto.LottoWinningResultResponseDto;

import java.util.EnumMap;
import java.util.List;

public final class LottoWinningChecker {

    private final Lotto WinningLotto;

    private LottoWinningChecker(Lotto WinningLotto) {
        this.WinningLotto = WinningLotto;
    }

    public static final LottoWinningChecker of(LottoWinningCheckRequestDto confirmationRequestDto) {
        return new LottoWinningChecker(confirmationRequestDto.getWinningLotto());
    }

    public static final LottoWinningChecker of(Lotto WinningLotto) {
        return new LottoWinningChecker(WinningLotto);
    }

    public final LottoWinningResultResponseDto getLottoWinningResultResponseDto(Lottos lottos) {
        List<Lotto> lottoList = lottos.getLottos();
        WinningScoreBoard winningScoreBoard = WinningScoreBoard.of(new EnumMap<>(WinningScore.class));
        for (Lotto lotto : lottoList) {
            int correctCount = lotto.getCorrectCount(WinningLotto);
            WinningScore winningScore = WinningScore.valueOf(correctCount);
            winningScoreBoard.increaseCount(winningScore);
        }
        return LottoWinningResultResponseDto.newInstance(winningScoreBoard);
    }

}
