package lotto.domain;

import lotto.dto.LottoMatchResult;
import lotto.dto.Money;
import lotto.dto.UserLotto;
import lotto.dto.WinningLotto;

import java.util.ArrayList;
import java.util.List;

public class Lotto {
    private static final long LOTTO_PRICE = 1_000;
    ILottoGenerator lottoGenerator;
    private UserLotto userLotto;
    private Money money;

    public Lotto(long money, ILottoGenerator lottoGenerator) {
        this.money = new Money(money);
        this.lottoGenerator = lottoGenerator;
    }

    public UserLotto getUserLotto() {
        return this.userLotto;
    }

    public void buy() {
        long ticketCount = this.money.getMoney() / LOTTO_PRICE;

        List<LottoTicket> tickets = new ArrayList<LottoTicket>();
        for (int i = 1; i <= ticketCount; i++) {
            tickets.add(new LottoTicket(lottoGenerator));
        }

        this.userLotto = new UserLotto(tickets);
    }

    public LottoMatchResult result(List<Integer> numbers) {
        WinningLotto winningLotto = new WinningLotto(numbers);
        LottoMatcher lottoMatcher = new LottoMatcher(userLotto, winningLotto);
        return lottoMatcher.getLottoMatchResult();
    }
}
