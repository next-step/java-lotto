package lotto.service;

import lotto.domain.*;
import lotto.domain.dto.ResultDto;
import lotto.domain.dto.WinningLottoTicketDto;

import java.util.ArrayList;
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
        WinnerLottoTicket winnerLottoTicket = WinnerLottoTicket.of(dto.getWinningNumbers(), dto.getBonusNumber());

        List<LottoResult> results = new ArrayList<>();
        for (LottoTicket ticket : dto.getLottoTickets().getLottoTickets()) {
            results.add(LottoResult.of(winnerLottoTicket, ticket));
        }

        WinningRank resultRank = new WinningRank();
        resultRank = resultRank.updateRank(results);

        return ResultDto.of(resultRank, Rate.of(resultRank.getMoney(), resultRank.getPrizeMoney()));
    }

}
