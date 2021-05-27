package lotto.domain;

import lotto.common.ErrorCode;
import lotto.common.WinningType;

import java.util.*;

public class GameResult {
    private List<GameWinningResult> gameWinningResults;

    public GameResult(LottoTicket winningLottoTicket, LottoTickets userLottoTickets, int bonusNumber) {
        throwDuplicatedBonusBallException(winningLottoTicket, bonusNumber);
        this.gameWinningResults = getGameResult(winningLottoTicket, userLottoTickets, bonusNumber);
    }


    private List<GameWinningResult> getGameResult(LottoTicket winningLottoTicket, LottoTickets userLottoTickets, int bonusNumber) {
        List<WinningType> winningResult = userLottoTickets.getWinningResult(winningLottoTicket, bonusNumber);
        List<GameWinningResult> gameWinningResult = new ArrayList<>();
        for(WinningType winningType : WinningType.values()) {
            gameWinningResult.add(new GameWinningResult(winningType, (int) winningResult.stream()
                                                                                    .filter(w -> w.equals(winningType))
                                                                                    .count()));
        }

        return gameWinningResult;
    }

    private void throwDuplicatedBonusBallException(LottoTicket winningLottoTicket, int bonusNumber) {
        if (winningLottoTicket.contains(LottoNumber.of(bonusNumber))) {
            throw new IllegalArgumentException(ErrorCode.DUPLICATED_BONUS_NUMBER.getErrorMessage());
        }
    }

    public List<GameWinningResult> getGameResult() {
        return gameWinningResults;
    }
}
