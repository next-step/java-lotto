package lotto.service;

import lotto.domain.Rate;
import lotto.domain.WinnerLottoTicket;
import lotto.domain.WinningRank;
import lotto.domain.dto.ResultDto;
import lotto.domain.dto.WinningLottoTicketDto;

import java.util.List;

public class WinningResult {

    private static class WinningResultHolder {
        private static final WinningResult WINNING_RESULT = new WinningResult();
    }

    private WinningResult() {
    }

    public static WinningResult getInstance() {
        return WinningResultHolder.WINNING_RESULT;
    }

    public ResultDto winningResult(WinningLottoTicketDto dto) {
        WinnerLottoTicket winnerLottoTicket = WinnerLottoTicket.of(dto.getWinnerNumber(), dto.getBonusNumber());
        List<Long> winningResult = winnerLottoTicket.findLottoMatchCount(dto.getLottoTickets());

        WinningRank resultRank = new WinningRank();
        resultRank = resultRank.updateRank(winningResult);

        return ResultDto.of(resultRank, Rate.of(resultRank.getMoney(), resultRank.getPrizeMoney()));
    }

}
