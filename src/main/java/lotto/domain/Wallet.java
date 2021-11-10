package lotto.domain;

import lotto.vo.Lottos;
import lotto.vo.Money;

import java.util.List;

import static java.util.stream.Collectors.groupingBy;

public class Wallet {

    private final Lottos lottos;
    private final Money myMoney;
    private Money winningMoney;

    private Wallet(Lottos lottos, Money myMoney) {
        this.lottos = lottos;
        this.myMoney = myMoney;
    }

    public static Wallet create(Lottos lottos, Money money) {
        return new Wallet(lottos, money);
    }

    public void checkWinning(Lotto winningLotto) {
        List<WinningRank> winningRanks = lottos.checkWinning(winningLotto);
        winningMoney = winningRanks.stream()
                .map(winningRank -> winningRank.getReward())
                .reduce((left, right) -> left.add(right))
                .orElseGet(() -> Money.create(0));
        System.out.println("winningMoney = " + winningMoney);
    }

    public boolean isEqualWinningMoney(Money expect) {
        return this.winningMoney.equals(expect);
    }

    //    public Map<WinningRank, Long> getWinningHistory(Lotto winningLotto) {
//        List<WinningRank> winningRanks = lottos.checkWinning(winningLotto);
//        return winningRanks.stream()
//                .filter(winningRank -> !winningRank.equals(WinningRank.NO_RANK))
//                .collect(groupingBy(winningRank -> winningRank, () -> new EnumMap<WinningRank, Long>(WinningRank.class), counting()));
//    }
}
