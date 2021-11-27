package lotto.service;

import java.util.ArrayList;
import java.util.List;
import lotto.domain.LottoResult;
import lotto.domain.LottoTicket;
import lotto.domain.LottoTickets;
import lotto.domain.Rate;
import lotto.domain.WinnerLottoTicket;
import lotto.domain.WinningRank;
import lotto.domain.dto.LottoResultDto;
import lotto.domain.dto.WinningNumberDto;

public class WinningResult {

    private static class WinningResultHolder {

        private static final WinningResult WINNING_RESULT = new WinningResult();
    }

    private WinningResult() {
    }

    public static WinningResult getInstance() {
        return WinningResultHolder.WINNING_RESULT;
    }

    public LottoResultDto winningResult(LottoTickets lottoTickets, WinningNumberDto winningNumberDto) {
        WinnerLottoTicket winnerLottoTicket = WinnerLottoTicket.of(winningNumberDto.getWinnerNumbers(),
            winningNumberDto.getBonusNumber());

        List<LottoResult> results = new ArrayList<>();
        for (LottoTicket ticket : lottoTickets.getLottoTickets()) {
            results.add(LottoResult.of(winnerLottoTicket, ticket));
        }

        WinningRank resultRank = new WinningRank();
        resultRank = resultRank.updateRank(results);

        return LottoResultDto.of(resultRank, Rate.of(resultRank.getMoney(), resultRank.getPrizeMoney()));
    }

}
