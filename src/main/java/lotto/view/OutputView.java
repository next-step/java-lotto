package lotto.view;

import lotto.domain.Lotto;

import java.util.List;

public class OutputView {
    public static void lottoTicketListView(List<Lotto> lottoTicket) {
        for (int i = 0; i < lottoTicket.size(); i++) {
            System.out.println(lottoTicket.get(i).toString());
        }
    }
}
