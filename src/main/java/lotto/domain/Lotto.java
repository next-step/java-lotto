package lotto.domain;

import lotto.dto.Money;
import lotto.dto.UserLotto;
import lotto.dto.WinningLotto;

import java.util.ArrayList;
import java.util.List;

public class Lotto {
    private static final int LOTTO_PRICE = 1_000;

    public static void buy() {
        int ticketCount = Money.getMoney() / LOTTO_PRICE;
        List<LottoTicket> tickets = new ArrayList<LottoTicket>();
        for (int i = 1; i <= ticketCount; i++) {
            tickets.add(new LottoTicket());
        }

        UserLotto.createUserLotto(tickets, ticketCount);
    }

    public static void winningLotto(List<Integer> values) {
        WinningLotto.createWinningLotto(values);
    }

    public static void createLottoMatch() {
        LottoMatcher.resultLottoMatch();
    }
}
