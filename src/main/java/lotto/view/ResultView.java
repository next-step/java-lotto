package lotto.view;

import lotto.domain.LottoTicket;
import lotto.dto.LottoMatchResult;
import lotto.dto.UserLotto;

import java.util.List;

public class ResultView {
    public static void resultUserTicketCount(UserLotto userLotto) {
        System.out.println(userLotto.toString());
    }

    public static void resultUserLotto(UserLotto userLotto) {
        List<LottoTicket> lottoTickets = userLotto.getUserLotto();
        for (LottoTicket ticket : lottoTickets) {
            System.out.println(ticket.toString());
        }
    }

    public static void resultMatch(LottoMatchResult lottoMatchResult) {
        System.out.println("당첨 통계");
        System.out.println("---------");
        System.out.println(lottoMatchResult.toString());
    }
}
