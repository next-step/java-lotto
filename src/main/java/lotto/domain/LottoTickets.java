package lotto.domain;

import java.util.List;

public class LottoTickets {

    private static final int LOTTO_PRICE = 1000;
    private final List<PlayersLotto> playersLottoTickets;

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
