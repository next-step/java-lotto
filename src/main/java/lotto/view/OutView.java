package lotto.view;

import lotto.domain.value.LottoTickets;

public class OutView {
    private static final String PURCHASE_COUNT_MESSAGE = "%s개를 구매했습니다.\n";

    public static void showLottoTickets(LottoTickets lottoTickets) {
        showNumbersOfTickets(lottoTickets);
        showDetailOfLottoTickets(lottoTickets);
    }

    private static void showNumbersOfTickets(LottoTickets lottoTickets) {
        System.out.printf(PURCHASE_COUNT_MESSAGE, lottoTickets.size());
    }

    private static void showDetailOfLottoTickets(LottoTickets lottoTickets) {
        lottoTickets.getDetailTickets()
                .forEach(lottoTicket -> System.out.println(lottoTicket.getNumbers()));
    }
}
