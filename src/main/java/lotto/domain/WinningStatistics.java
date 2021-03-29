/*
* 로또 당첨 개수를 보유하는 클래스, 수익률 계산을 담당한다
* */
package lotto.domain;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class WinningStatistics {

    private final Map<Rank, Integer> winningStatistics = new HashMap<>();

    public WinningStatistics(Lottos lottos, WinningNumbers winningNumbers) {
        lottos.checkWinning(winningNumbers);
    }


    /*
     * 구매한 금액을 인자로 받아 당첨금액/구매금액 수익률을 계산한다.
     * */
//    public double yield(int buyNum) {
//        Long winningMoney = Rank.calculate(match);
//        int buyMoney = buyNum * LOTTO_PRICE;
//        return winningMoney / buyMoney;
//    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        WinningStatistics that = (WinningStatistics) o;
        return Objects.equals(winningStatistics, that.winningStatistics);
    }

    @Override
    public int hashCode() {
        return Objects.hash(winningStatistics);
    }
}
