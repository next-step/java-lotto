package step2.view;

import step2.domain.LottoTicket;
import step2.domain.Winner;

import java.util.List;

public class ResultView {
    public void printLottoTickets(List<LottoTicket> lottoTickets) {
        System.out.println(lottoTickets.size() + "를 구매했습니다.");

        for(LottoTicket lottoTicket : lottoTickets) {
            printLottoTicket(lottoTicket);
        }
    }

    private void printLottoTicket(LottoTicket lottoTicket) {
        List<Integer> lottoNums = lottoTicket.getLottoNums();

        System.out.println(String.join(",", String.valueOf(lottoNums)));
    }

    public void printWinnerStatistics(Winner winner) {
    }
}
