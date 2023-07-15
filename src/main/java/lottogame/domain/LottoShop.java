package lottogame.domain;

import lottogame.domain.spi.NumberGenerator;

import java.util.ArrayList;
import java.util.List;

public class LottoShop {

    public List<LottoTicket> purchase(int money, NumberGenerator numberGenerator) {
        assertMoney(money);
        return createLottoTickets(money, numberGenerator);
    }

    private void assertMoney(int money) {
        if (money % LottoTicket.PURCHASABLE_UNIT != 0) {
            throw new IllegalArgumentException(
                    String.format("money는 \"%d\"원으로 나누어 떨어져야 합니다 money: \"%d\"", LottoTicket.PURCHASABLE_UNIT, money));
        }
    }

    private List<LottoTicket> createLottoTickets(int money, NumberGenerator numberGenerator) {
        List<LottoTicket> lottoTicketList = new ArrayList<>();
        for (int count = 0; count < money / LottoTicket.PURCHASABLE_UNIT; count++) {
            lottoTicketList.add(new LottoTicket(numberGenerator));
        }
        return lottoTicketList;
    }
}
