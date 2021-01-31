package lotto.domain;

import java.util.List;

public class LottoTickets {

    private final List<PlayersLotto> playersLottoTickets;
    private static final int LOTTO_PRICE = 1000;

    public LottoTickets(List<PlayersLotto> playersLottoTickets) {
        this.playersLottoTickets = playersLottoTickets;
    }

    public List<PlayersLotto> getLottoTickets() {
        return playersLottoTickets;
    }

    public static int countTicketNumberByMoney(int money) {
        return money / LOTTO_PRICE;
    }
}
