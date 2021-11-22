package lotto.domain;

import lotto.vo.LottoNumber;
import lotto.vo.Lottos;
import lotto.vo.Money;
import lotto.vo.WinningHistory;

import java.math.BigDecimal;
import java.util.Collections;
import java.util.List;

public class Wallet {

    private final Lottos lottos;
    private Money myMoney;
    private Money originMoney;

    private Wallet(Money money, Lottos lottos) {
        this.myMoney = money;
        this.originMoney = money;
        this.lottos = lottos;
    }

    public static Wallet create(Money money, Lottos lottos) {
        return new Wallet(money, lottos);
    }

    public static Wallet create(Money money) {
        return new Wallet(money, Lottos.create(Collections.EMPTY_LIST));
    }

    public Lottos getLottos() {
        return lottos;
    }

    public Money getAllMoney() {
        Money money = Money.create(myMoney.getValue());
        myMoney = Money.ZERO;
        return money;
    }

    public Wallet saveLottos(Lottos lottos) {
        return create(this.myMoney, lottos);
    }

    public WinningHistory getWinningHistory(Lotto winningLotto, LottoNumber bonus) {
        List<WinningRank> winningRanks = findWinningRanks(winningLotto, bonus);
        Money winningMoney = getWinningMoney(winningRanks);
        return WinningHistory.create(originMoney, winningRanks, winningMoney);
    }

    private List<WinningRank> findWinningRanks(Lotto winningLotto, LottoNumber bonus) {
        return WinningRank.findWinningRanks(lottos, winningLotto, bonus);
    }

    private Money getWinningMoney(List<WinningRank> winningRanks) {
        return winningRanks.stream()
                .map(winningRank -> winningRank.getReward())
                .reduce((left, right) -> left.add(right))
                .orElseGet(() -> Money.create(BigDecimal.ZERO));
    }
}
