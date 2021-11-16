package lotto.domain;

import lotto.vo.Lottos;
import lotto.vo.Money;
import lotto.vo.WinningHistory;

import java.math.BigDecimal;
import java.util.List;

public class Wallet {

    private Lottos lottos;
    private Money myMoney;

    private Wallet(Money myMoney) {
        this.myMoney = myMoney;
    }

    public static Wallet create(Money money) {
        return new Wallet(money);
    }

    public WinningHistory checkWinning(Lotto winningLotto) {
        List<WinningRank> winningRanks = WinningRank.checkWinning(lottos, winningLotto);
        Money winningMoney = winningRanks.stream()
                .map(winningRank -> winningRank.getReward())
                .reduce((left, right) -> left.add(right))
                .orElseGet(() -> Money.create(BigDecimal.ZERO));
        return WinningHistory.create(myMoney, winningRanks, winningMoney);
    }

    public Money getMoneyToBuy() {
        Money havingMoney = Money.create(myMoney.getValue());
        myMoney = Money.create(BigDecimal.ZERO);
        return havingMoney;
    }

    public void saveLottos(Lottos lottos) {
        this.lottos = lottos;
    }
}
