package lotto.view;

import lotto.domain.LottoTicket;

import java.util.List;

public class ResultView {

    private static final String COUNT_OF_LOTTO_MESSAGE = "개를 구매했습니다.";

    private ResultView() {
    }

    public static void viewCountOfLotto(int countOfTickets) {
        System.out.println(countOfTickets + COUNT_OF_LOTTO_MESSAGE);
    }

    public static void viewLottoTickets(List<LottoTicket> lottoTickets) {
        for (LottoTicket lottoTicket : lottoTickets) {
            System.out.println(lottoTicket.getLottoNumbers());
        }
    }
}
