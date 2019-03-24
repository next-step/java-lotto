package lotto.domain;

import lotto.dto.LottoMatchResult;
import lotto.dto.Money;
import lotto.dto.UserLotto;
import lotto.dto.WinningLotto;
import lotto.rule.LottoSetUp;

import java.util.ArrayList;
import java.util.List;

public class Lotto {
    private final int LOTTO_PRICE;
    private UserLotto userLotto;
    private WinningLotto winningLotto;
    private Money money;

    public Lotto(Money money) {
        if (LottoSetUp.lottoTicketPrice == 0)
            throw new IllegalArgumentException("Ticket Price is 0");

        LOTTO_PRICE = LottoSetUp.lottoTicketPrice;
        this.money = money;
    }

    public UserLotto getUserLotto() {
        return this.userLotto;
    }

    public WinningLotto getWinningUserLotto() {
        return this.winningLotto;
    }

    public void buy() {
        int ticketCount = money.getMoney() / LOTTO_PRICE;
        List<LottoTicket> tickets = new ArrayList<LottoTicket>();

        for (int i = 1; i <= ticketCount; i++) {
            tickets.add(new LottoTicket());
        }

        userLotto = new UserLotto(ticketCount, tickets);
    }

    public void winningLotto(List<Integer> values) {
        winningLotto = new WinningLotto(values);
    }

    public LottoMatchResult result() {
        LottoMatcher lottoMatcher = new LottoMatcher(userLotto, winningLotto, money);
        return lottoMatcher.resultLottoMatch();
    }
}
