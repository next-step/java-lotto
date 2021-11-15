package lotto.domain;

import lotto.vo.Lottos;
import lotto.vo.Money;
import lotto.vo.WinningHistory;

import java.math.BigDecimal;
import java.util.List;

public class Wallet {

    private final Lottos lottos;
    private final Money originMoney;

    private Wallet(Lottos lottos, Money originMoney) {
        this.lottos = lottos;
        this.originMoney = originMoney;
    }

    public static Wallet create(Lottos lottos, Money money) {
        return new Wallet(lottos, money);
    }

    public WinningHistory checkWinning(Lotto winningLotto) {
        List<WinningRank> winningRanks = WinningRank.checkWinning(lottos, winningLotto);
        Money winningMoney = winningRanks.stream()
                .map(winningRank -> winningRank.getReward())
                .reduce((left, right) -> left.add(right))
                .orElseGet(() -> Money.create(BigDecimal.ZERO));
        return WinningHistory.create(originMoney, winningRanks, winningMoney);
    }

}
