package lotto.view.result;

import lotto.domain.ticket.LottoTicket;
import lotto.domain.ticket.LottoTickets;
import lotto.dto.LottoResultDto;

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
        System.out.println(String.format("3개 일치 (%d원)- %d개", lottoResultDto.getThreeMatch().getWinningAmount(), lottoResultDto.getThreeMatch().getTicketCount()));
        System.out.println(String.format("4개 일치 (%d원)- %d개", lottoResultDto.getFourMatch().getWinningAmount(), lottoResultDto.getFourMatch().getTicketCount()));
        System.out.println(String.format("5개 일치 (%d원)- %d개", lottoResultDto.getFiveMatch().getWinningAmount(), lottoResultDto.getFiveMatch().getTicketCount()));
        System.out.println(String.format("6개 일치 (%d원)- %d개", lottoResultDto.getSixMatch().getWinningAmount(), lottoResultDto.getSixMatch().getTicketCount()));
        System.out.println(String.format("총 수익률은 %.2f입니다.", lottoResultDto.getEarningRate()));
    }
}
