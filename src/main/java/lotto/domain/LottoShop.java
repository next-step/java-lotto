package lotto.domain;

import java.util.ArrayList;
import java.util.List;

/**
 * 로또 티켓을 생성하고 관리
 */
public class LottoShop {
    private static final int PRICE_PER_TICKET = 1000;
    private final int purchasePrice;
    private final int ticketAmount;
    private final List<LottoTicket> lottoTickets;

    public LottoShop(int price, LottoAutoGenerator lottoAutoGenerator) {
        validatePrice(price);
        this.purchasePrice = price;
        this.ticketAmount = calculateTicketAmount(price);
        List<LottoTicket> temp = new ArrayList<>();
        for (int i = 0; i < ticketAmount; i++) {
            temp.add(lottoAutoGenerator.generateLottoTicket());
        }
        this.lottoTickets = List.copyOf(temp);
    }

    private void validatePrice(int price) {
        if (price < 0) {
            throw new IllegalArgumentException("로또 구매 가능 가격은 0원 이상입니다.");
        }
    }

    private int calculateTicketAmount(int price) {
        return price / PRICE_PER_TICKET;
    }

    public List<List<Integer>> getLottoTicketsNumber() {
        List<List<Integer>> lottos = new ArrayList<>();
        lottoTickets.forEach(l -> lottos.add(l.getNumbers()));
        return lottos;
    }

    public int getPurchasePrice() {
        return this.purchasePrice;
    }

    public int getTicketAmount() {
        return ticketAmount;
    }
}
