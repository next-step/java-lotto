package lotto.view;

import lotto.domain.LottoMachine;
import lotto.domain.LottoRank;
import lotto.domain.LottoTicket;

import java.util.List;

public class ResultView {

    public void printLottoTicketInfos(LottoMachine lottoMachine) {
        List<LottoTicket> tickets = lottoMachine.getLottoTickets();

        tickets.stream()
                .forEach(ticket -> System.out.println(ticket.getLottoNumber().toString()));
    }

    public void printLottoRanksInfos(List<LottoRank> readOnlyLottoRanks) {
        readOnlyLottoRanks.stream()
                .forEach(this::printLottoRank);
    }

    public void printLottoRank(LottoRank lottoRank) {
        System.out.println("lottoRank.getRank() = " + lottoRank.getRank());
        System.out.println("lottoRank.getWinnerCount() = " + lottoRank.getWinnerCount());
    }
}
