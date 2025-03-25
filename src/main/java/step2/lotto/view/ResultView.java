package step2.lotto.view;

import step2.lotto.model.LottoTicket;
import step2.lotto.model.LottoTicketList;

public class ResultView {

    public void printLottoTicketCount(LottoTicketList lottoTicketList) {
        System.out.println(lottoTicketList.value().size() + "개를 구매했습니다.");
        for (LottoTicket lottoTicket : lottoTicketList.value()) {
            printLottoTicket(lottoTicket);
        }
    }

    public void printLottoTicket(LottoTicket lottoTicket) {
        System.out.println(lottoTicket);
    }

}
