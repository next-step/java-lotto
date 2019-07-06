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
        System.out.println(String.format("\n수동으로 %d장, 자동으로 %d개를 구매했습니다.", 0, 0));
        lottoTickets.findAll().stream()
                .forEach(lottoTicket -> printLottoTicket(lottoTicket));
        System.out.println();
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
        System.out.println(String.format("5개 일치, 보너스 볼 일치(%d원) - %d개", LottoWinningAmount.FIVE_AND_BONUS_MATCH.getWinningAmount(),  lottoWinningResult.getWinningCount(LottoWinningAmount.FIVE_AND_BONUS_MATCH)));
        System.out.println(String.format("6개 일치 (%d원)- %d개", LottoWinningAmount.SIX_MATCH.getWinningAmount(),  lottoWinningResult.getWinningCount(LottoWinningAmount.SIX_MATCH)));
        System.out.println(String.format("총 수익률은 %.2f입니다.", lottoResultDto.getEarningRate()));
    }
}
