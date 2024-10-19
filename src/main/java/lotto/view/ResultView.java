package lotto.view;

import lotto.domain.LottoRank;
import lotto.domain.ticket.Lotto;
import lotto.domain.ticket.LottoTickets;
import lotto.domain.winning.WinningNumbers;
import lotto.domain.winning.WinningTickets;
import lotto.utils.StringUtils;

public class ResultView {

    public void printLottoTickets(LottoTickets lottoTickets) {
        for (int i = 0; i < lottoTickets.getLottoTicketsSize(); i++) {
            print(lottoTickets.getLottoTicketString(i));
        }

        print(StringUtils.BLANK);
    }

    public void getResultAndPrint(LottoTickets lottoTickets, WinningNumbers winningNumbers) {
        printStats(lottoTickets.findWinning(winningNumbers), lottoTickets.getLottoTicketsSize());
    }

    private void printStats(WinningTickets winningTickets, int lottoTicketsSize) {
        print(StringUtils.BLANK);
        print("당첨 통계");
        print("---------");

        print("3개 일치 (5000원) - " + winningTickets.getWinningTicketCount(LottoRank.FIFTH));
        print("4개 일치 (50000원) - " + winningTickets.getWinningTicketCount(LottoRank.FOURTH));
        print("5개 일치 (1500000원) - " + winningTickets.getWinningTicketCount(LottoRank.THIRD));
        print("5개 일치, 보너스 볼 일치(30000000원) - " + winningTickets.getWinningTicketCount(LottoRank.SECOND));
        print("6개 일치 (2000000000원) - " + winningTickets.getWinningTicketCount(LottoRank.FIRST));

        print("총 수익률은 " + winningTickets.getWinningPrice() / ((long) Lotto.LOTTO_TICKET_PRICE * lottoTicketsSize) + "입니다.");
    }

    public void print(String message) {
        System.out.println(message);
    }

}
