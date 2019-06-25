package lotto.view;

import lotto.domain.LottoTicket;
import lotto.domain.LottoTickets;

/**
 * Created by wyparks2@gmail.com on 2019-06-25
 * Blog : http://wyparks2.github.io
 * Github : http://github.com/wyparks2
 */
public class ResultView {
    private static final String PURCHASED_LOTTO_TICKETS_TOTAL_SUFFIX_MESSAGE = "개를 구매했습니다.";

    public static void printPurchasedLottoTickets(LottoTickets lottoTickets) {
        System.out.println(lottoTickets.getLottoTickets().size() + PURCHASED_LOTTO_TICKETS_TOTAL_SUFFIX_MESSAGE);

        for (LottoTicket lottoTicket : lottoTickets.getLottoTickets()) {
            System.out.println(lottoTicket);
        }
    }
}
