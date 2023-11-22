package lotto.view;

import lotto.domain.Lotto;
import lotto.domain.LottoTicket;

public class ResultView {
    public static void lottoTicketView(LottoTicket lottoTicket) {
        for (Lotto lotto: lottoTicket.getLottoTicket()) {
            System.out.println(lotto.toString());
        }
    }
}
