package lotto.view.result;

import lotto.domain.ticket.LottoTicket;
import lotto.domain.ticket.LottoTickets;
import lotto.domain.winning.LottoWinningAmount;
import lotto.domain.winning.LottoWinningResult;
import lotto.dto.LottoResultDto;

import java.util.Map;

public class DefaultResultView implements ResultView {

    @Override
    public void printLottoTickets(LottoTickets lottoTickets) {
        lottoTickets.findAll().stream()
                .forEach(lottoTicket -> printLottoTicket(lottoTicket));
    }

    private void printLottoTicket(LottoTicket lottoTicket) {
        System.out.println("[" + lottoTicket.getLottoTicketNumbers() + "]");
    }

    @Override
    public void printResult(LottoResultDto lottoResultDto) {
        System.out.println("\n당첨 통계\n---------");
        LottoWinningResult lottoWinningResult = lottoResultDto.getWinningResult();
        System.out.println(String.format("3개 일치 (%d원)- %d개", LottoWinningAmount.THREE_MATCH.getWinningAmount(), lottoWinningResult.getWinningCount(LottoWinningAmount.THREE_MATCH)));
        System.out.println(String.format("4개 일치 (%d원)- %d개", LottoWinningAmount.FOUR_MATCH.getWinningAmount(),  lottoWinningResult.getWinningCount(LottoWinningAmount.FOUR_MATCH)));
        System.out.println(String.format("5개 일치 (%d원)- %d개", LottoWinningAmount.FIVE_MATCH.getWinningAmount(),  lottoWinningResult.getWinningCount(LottoWinningAmount.FIVE_MATCH)));
        System.out.println(String.format("6개 일치 (%d원)- %d개", LottoWinningAmount.SIX_MATCH.getWinningAmount(),  lottoWinningResult.getWinningCount(LottoWinningAmount.SIX_MATCH)));
        System.out.println(String.format("총 수익률은 %.2f입니다.", lottoResultDto.getEarningRate()));
    }
}
