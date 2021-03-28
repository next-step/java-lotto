package step2.domain.checker;

import step2.domain.winning.WinningScore;
import step2.domain.lotto.Lotto;
import step2.domain.lotto.LottoList;
import step2.domain.winning.WinningScoreBoard;
import step2.dto.LottoConfirmationRequestDto;

import java.util.EnumMap;
import java.util.List;

public final class LottoWinningChecker {

    private final Lotto WinningLotto;

    public static final LottoWinningChecker newInstance(LottoConfirmationRequestDto confirmationRequestDto) {
        return new LottoWinningChecker(confirmationRequestDto);
    }

    public static final LottoWinningChecker newInstance(Lotto WinningLotto) {
        return new LottoWinningChecker(WinningLotto);
    }

    private LottoWinningChecker(LottoConfirmationRequestDto confirmationRequestDto) {
        this(confirmationRequestDto.getLotto());
    }

    private LottoWinningChecker(Lotto WinningLotto) {
        this.WinningLotto = WinningLotto;
    }

    public void 비즈니스_로직을_검증하기위한_메서드(LottoList lottoList) {
        List<Lotto> lottos = lottoList.getLottoList();
        WinningScoreBoard winningScoreBoard = WinningScoreBoard.newInstance(new EnumMap<>(WinningScore.class));
        for(Lotto lotto : lottos) {
            WinningScore winningScore = WinningScore.valueOf(lotto.getCorrectCount(lotto));
            winningScoreBoard.increaseCount(winningScore);
        }

    }

}
