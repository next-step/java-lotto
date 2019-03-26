package lotto.view;

import lotto.domain.LottoTicket;
import lotto.dto.LottoMatchResult;
import lotto.dto.UserLotto;
import java.util.List;

public class ResultView {
    public static void resultUserTicketCount() {
        System.out.println(String.format("%s 개를 구매했습니다.", UserLotto.getTicketCount()));
    }

    public static void resultUserLotto() {
        List<LottoTicket> lottoTickets = UserLotto.getUserLotto();
        for (LottoTicket ticket : lottoTickets) {
            System.out.println(ticket.toString());
        }
    }

    public static void resultMatch() {
        System.out.println("당첨 통계");
        System.out.println("---------");
        System.out.println(LottoMatchResult.printLottResult());
    }
}
