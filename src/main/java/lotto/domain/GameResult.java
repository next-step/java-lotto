package lotto.domain;

import lotto.common.WinningType;

import java.util.*;

public class GameResult {
    private List<GameWinningResult> gameWinningResults;

    public GameResult(WinningLottoTicket winningLottoTicket, List<LottoTicket> userLottoTickets) {
        this.gameWinningResults = getGameResult(winningLottoTicket, userLottoTickets);
    }

    private List<GameWinningResult> getGameResult(WinningLottoTicket winningLottoTicket, List<LottoTicket> userLottoTickets) {
        List<WinningType> winningResult = winningLottoTicket.getWinningResult(userLottoTickets);
        List<GameWinningResult> gameWinningResult = new ArrayList<>();
        for(WinningType winningType : WinningType.values()) {
            gameWinningResult.add(new GameWinningResult(winningType, (int) winningResult.stream()
                                                                                    .filter(w -> w.equals(winningType))
                                                                                    .count()));
        }

        return gameWinningResult;
    }

    public List<GameWinningResult> getGameResult() {
        return gameWinningResults;
    }
}
