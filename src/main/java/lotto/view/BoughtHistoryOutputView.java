package lotto.view;

import lotto.domain.Money;

public class BoughtHistoryOutputView {
    private static final String BOUGHT_TICKETS_FOOTER = "개를 구매했습니다.";

    public static String getHowManyLottoTickets(Money money) {
        return money.howManyLottoTickets() + BOUGHT_TICKETS_FOOTER;
    }
}
