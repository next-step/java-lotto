/*
 * 로또 당첨 개수를 보유하는 클래스, 수익률 계산을 담당한다
 * */
package lotto.domain;

import java.util.*;

import static lotto.domain.Rank.LOTTO_PRICE;

public class WinningStatistics {

    private Map<Rank, Integer> winningStatistics = new LinkedHashMap<>();

    public WinningStatistics(Lottos lottos, WinningNumbers winningNumbers) {
        Arrays.stream(Rank.values())
                .forEach(rank -> winningStatistics.put(rank, 0));

        lottos.checkWinning(winningNumbers)
                .forEach(rank -> winningStatistics.merge(rank, 1, Integer::sum));
    }

    /*
     * 테스트용 생성자
     * */
    public WinningStatistics(Map<Rank, Integer> winningStatistics) {
        this.winningStatistics = winningStatistics;
    }

    /*
     * 구매한 금액을 인자로 받아 당첨금액/구매금액 수익률을 계산한다.
     * */
    public double yield(int buyNum) {
        int buyMoney = buyNum * LOTTO_PRICE;
        Long totalWinningMoney = winningStatistics.entrySet().stream()
                .mapToLong(m -> m.getKey().getWinningMoney() * m.getValue())
                .sum();
        return totalWinningMoney / buyMoney;
    }

    public Map<Rank, Integer> winningStatistics() {
        return Collections.unmodifiableMap(winningStatistics);
    }

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
