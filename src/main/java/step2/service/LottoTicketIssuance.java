package step2.service;

import step2.domain.entity.Lotto;
import step2.domain.entity.LottoTicket;
import step2.domain.entity.LottoTickets;
import step2.domain.vo.Money;

import java.util.ArrayList;
import java.util.List;

public class LottoTicketIssuance {

    private LottoTicketIssuance() {
    }

    public static LottoTickets issues(Money buyerMoney) {
        var money = buyerMoney.getMoney();
        var price = Lotto.PRICE;

        validateLottoIssuance(money, price);

        List<LottoTicket> tickets = new ArrayList<>();

        while (canIssueLottoTicket(money)) {
            money -= price;
            tickets.add(issue());
        }

        return new LottoTickets(tickets);
    }

    private static LottoTicket issue() {
        return new LottoTicket(LottoIssuance.issue());
    }

    private static void validateLottoIssuance(int money, int price) {
        if (money < price) {
            final var message = String.format(
                    "구입 금액이 로또 1장 가격보다 작아서 로또를 발급받을 수 없습니다. 구입 금액: %d, 로또 1장 가격: %d",
                    money,
                    price
            );

            throw new IllegalStateException(message);
        }
    }

    private static boolean canIssueLottoTicket(int money) {
        return money >= Lotto.PRICE;
    }

}
