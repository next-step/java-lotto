package lotto.view;

import lotto.domain.ticket.Lotto;
import lotto.domain.ticket.LottoTickets;
import lotto.domain.winning.WinningTickets;
import lotto.utils.StringUtils;

public class ResultView {

    public void printLottoTickets(LottoTickets lottoTickets) {
        for (int i = 0; i < lottoTickets.getLottoTicketsSize(); i++) {
            print(lottoTickets.getLottoTicketString(i));
        }

        print(StringUtils.BLANK);
    }

    public void getResultAndPrint(LottoTickets lottoTickets, String[] winningNumbers) {
        printStats(lottoTickets.findWinning(winningNumbers), lottoTickets.getLottoTicketsSize());
    }

    private void printStats(WinningTickets winningTickets, int lottoTicketsSize) {
        print(StringUtils.BLANK);
        print("당첨 통계");
        print("---------");

        print("3개 일치 (5000원) - " + winningTickets.getWinningTicketCount(3));
        print("4개 일치 (50000원) - " + winningTickets.getWinningTicketCount(4));
        print("5개 일치 (1500000원) - " + winningTickets.getWinningTicketCount(5));
        print("6개 일치 (2000000000원) - " + winningTickets.getWinningTicketCount(6));

        print("총 수익률은 " + winningTickets.getWinningPrice() / ((long) Lotto.LOTTO_TICKET_PRICE * lottoTicketsSize) + "입니다.");
    }

    public void print(String message) {
        System.out.println(message);
    }

}
