package lotto.domain;

import lotto.dto.LottoMatchResult;
import lotto.dto.Money;
import lotto.dto.UserLotto;
import lotto.dto.WinningLotto;
import java.util.List;

public class LottoMatcher {
    private UserLotto userLotto;
    private WinningLotto winningLotto;
    private Money money;

    public LottoMatcher(UserLotto userLotto, WinningLotto winningLotto, Money money) {
        this.userLotto = userLotto;
        this.winningLotto = winningLotto;
        this.money = money;
    }

    public LottoMatchResult resultLottoMatch() {
        LottoMatchResult lottoMatchResult = new LottoMatchResult(this.money);

        for (LottoTicket ticket : userLotto.getUserLotto()) {
            lottoMatchResult.addMatchResult(matchNumberCount(ticket));
        }
        return lottoMatchResult;
    }

    public int matchNumberCount(LottoTicket ticket) {
        List<Integer> winingLottoNumbers = winningLotto.getWinningLotto();

        final int[] matchCount = {0};
        ticket.getTicket().stream().forEach(number -> {
            if (winingLottoNumbers.contains(number)) {
                matchCount[0] += 1;
            }
        });

        return matchCount[0];
    }
}
