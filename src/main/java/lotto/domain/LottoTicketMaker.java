package lotto.domain;

import java.util.List;

public class LottoTicketMaker {
    public static LottoTickets buy(int price, List<LottoTicket> manualNumbers) {
        validateManualLottoCount(price, manualNumbers);
        LottoTickets manualTickets = new LottoTickets(manualNumbers);
        LottoTickets autoTickets = LottoTickets.createByCount(getAutoCount(price, manualNumbers.size()));
        return manualTickets.merge(autoTickets);
    }

    private static void validateManualLottoCount(int price, List<LottoTicket> manualNumbers) {
        if (manualNumbers.size() > getTotalCount(price)) {
            throw new IllegalArgumentException("수동으로 구매할 로또 수가 총 로또 수보다 많습니다.");
        }
    }

    private static int getAutoCount(int price, int manualCount) {
        return getTotalCount(price) - manualCount;
    }

    private static int getTotalCount(int price) {
        return price / LottoTicket.PRICE;
    }
}
