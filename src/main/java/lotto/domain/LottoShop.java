package lotto.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * 로또 티켓을 판매
 */
public class LottoShop {
    private static final Money PRICE_PER_TICKET = new Money(1000);
    private static final LottoAutoGenerator LOTTO_AUTO_GENERATOR = new LottoAutoGenerator();

    public List<LottoTicket> sellLotto(Money price, List<LottoTicket> manualLotto) {
        int totalAmount = price.getPrice() / PRICE_PER_TICKET.getPrice();
        validateManualLottoAmount(totalAmount, manualLotto.size());
        int autoAmount = totalAmount - manualLotto.size();

        List<LottoTicket> autoLotto = sellAutoLottoTicket(autoAmount);
        return Stream.concat(manualLotto.stream(), autoLotto.stream())
                .collect(Collectors.toList());
    }

    private void validateManualLottoAmount(int totalAmount, int manualAmount) {
        if (manualAmount > totalAmount) {
            throw new IllegalArgumentException("수동 로또의 갯수가 전체 로또 갯수를 넘을 수 없습니다.");
        }
    }

    private TicketAmount calculateTicketAmount(Money price) {
        return new TicketAmount(price.getPrice() / PRICE_PER_TICKET.getPrice());
    }

    private List<LottoTicket> sellAutoLottoTicket(int amount) {
        List<LottoTicket> tickets = new ArrayList<>();
        for (int i = 0; i < amount; i++) {
            tickets.add(LOTTO_AUTO_GENERATOR.generateLottoTicket());
        }
        return tickets;
    }

}
