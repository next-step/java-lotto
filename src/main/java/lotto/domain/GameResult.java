package lotto.domain;

import lotto.common.ErrorCode;
import lotto.common.WinningType;

import java.util.*;

public class GameResult {
    private List<LottoTicketGameResult> lottoTicketGameResults;

    public GameResult(LottoTicket winningLottoTicket, LottoTickets userLottoTickets, int bonusNumber) {
        throwDuplicatedBonusBallException(winningLottoTicket, bonusNumber);
        this.lottoTicketGameResults = getGameResult(winningLottoTicket, userLottoTickets, bonusNumber);
    }


    private List<LottoTicketGameResult> getGameResult(LottoTicket winningLottoTicket, LottoTickets userLottoTickets, int bonusNumber) {
        List<WinningType> winningResult = userLottoTickets.getWinningResults(winningLottoTicket, bonusNumber);
        List<LottoTicketGameResult> gameLottoTicketGameResult = new ArrayList<>();
        for(WinningType winningType : WinningType.values()) {
            gameLottoTicketGameResult.add(new LottoTicketGameResult(winningType, (int) winningResult.stream()
                                                                                    .filter(w -> w.equals(winningType))
                                                                                    .count()));
        }

        return gameLottoTicketGameResult;
    }

    private void throwDuplicatedBonusBallException(LottoTicket winningLottoTicket, int bonusNumber) {
        if (winningLottoTicket.contains(LottoNumber.of(bonusNumber))) {
            throw new IllegalArgumentException(ErrorCode.DUPLICATED_BONUS_NUMBER.getErrorMessage());
        }
    }

    public List<LottoTicketGameResult> getGameResult() {
        return lottoTicketGameResults;
    }
}
